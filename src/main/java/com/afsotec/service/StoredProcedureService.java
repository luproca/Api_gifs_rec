package com.afsotec.service;

import com.afsotec.dto.DatabaseResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

/**
 * Servicio centralizado para ejecutar procedimientos almacenados.
 */
@Service
public class StoredProcedureService {

    private static final Logger logger = LoggerFactory.getLogger(StoredProcedureService.class);
    private final ObjectMapper objectMapper = new ObjectMapper();

    private final Map<String, String> errorCodeMap = initErrorCodeMap();

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * Inicializa el mapa de códigos de error y sus mensajes correspondientes.
     */
    private Map<String, String> initErrorCodeMap() {
        Map<String, String> errorMap = new HashMap<>();

        // Códigos de error de Oracle específicos de la aplicación
        errorMap.put("ORA-01403", "No se encontraron datos");
        errorMap.put("ORA-20001", "Cuenta no encontrada");
        errorMap.put("ORA-20002", "Cuenta inactiva o bloqueada");
        errorMap.put("ORA-20003", "Saldo insuficiente");
        errorMap.put("ORA-20004", "Caja no encontrada o inactiva");
        errorMap.put("ORA-20005", "Transacción no permitida");

        // Códigos de error generales de Oracle
        errorMap.put("ORA-00001", "Violación de restricción única");
        errorMap.put("ORA-02291", "Violación de integridad referencial");
        errorMap.put("ORA-01017", "Usuario/contraseña inválidos");

        return errorMap;
    }

    /**
     * Ejecuta un procedimiento almacenado y convierte la respuesta JSON a un objeto DatabaseResponse.
     *
     * @param procedureName Nombre del procedimiento almacenado
     * @param params Parámetros para el procedimiento
     * @param jsonParamName Nombre del parámetro de salida que contiene el JSON
     * @return Objeto DatabaseResponse con los resultados
     */
    @Retryable(
            value = {SQLException.class, DataAccessException.class},
            maxAttempts = 3,
            backoff = @Backoff(delay = 1000)
    )
    @Transactional
    public DatabaseResponse executeStoredProcedure(String procedureName, Map<String, Object> params, String jsonParamName) {
        try {
            logger.debug("Ejecutando procedimiento: {} con parámetros: {}", procedureName, params);

            SimpleJdbcCall jdbcCall = configureJdbcCall(procedureName, params, jsonParamName);

            // Preparar los parámetros para la llamada
            MapSqlParameterSource parameterSource = new MapSqlParameterSource();
            params.forEach(parameterSource::addValue);

            // Ejecutar el procedimiento
            Map<String, Object> result = jdbcCall.execute(parameterSource);

            // Obtener el resultado JSON
            String jsonResult = (String) result.get(jsonParamName);
            logger.debug("Resultado del procedimiento {}: {}", procedureName, jsonResult);

            // Parsear el resultado a DatabaseResponse
            return parseJsonResponse(jsonResult);

        } catch (DataAccessException e) {
            logger.error("Error de acceso a datos al ejecutar {}: {}", procedureName, e.getMessage(), e);
            return handleDatabaseException(e);
        } catch (Exception e) {
            logger.error("Error general al ejecutar {}: {}", procedureName, e.getMessage(), e);
            return DatabaseResponse.error("Error interno del servidor: " + e.getMessage());
        }
    }

    /**
     * Configura la llamada JDBC para el procedimiento almacenado.
     */
    private SimpleJdbcCall configureJdbcCall(String procedureName, Map<String, Object> params, String jsonParamName) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withProcedureName(procedureName);

        // Configurar parámetros de entrada
        for (Map.Entry<String, Object> entry : params.entrySet()) {
            Object value = entry.getValue();
            int sqlType = getSqlType(value);
            jdbcCall.addDeclaredParameter(new SqlParameter(entry.getKey(), sqlType));
        }

        // Configurar parámetro de salida JSON
        jdbcCall.addDeclaredParameter(new SqlOutParameter(jsonParamName, Types.VARCHAR));

        return jdbcCall;
    }

    /**
     * Determina el tipo SQL basado en el tipo Java del valor.
     */
    private int getSqlType(Object value) {
        if (value == null) return Types.NULL;
        if (value instanceof Integer) return Types.INTEGER;
        if (value instanceof Long) return Types.BIGINT;
        if (value instanceof String) return Types.VARCHAR;
        if (value instanceof Double) return Types.DOUBLE;
        if (value instanceof java.math.BigDecimal) return Types.NUMERIC;
        if (value instanceof Boolean) return Types.BOOLEAN;
        if (value instanceof java.sql.Date) return Types.DATE;
        if (value instanceof java.sql.Timestamp) return Types.TIMESTAMP;

        return Types.VARCHAR; // Tipo por defecto
    }

    /**
     * Parsea el resultado JSON a un objeto DatabaseResponse.
     */
    private DatabaseResponse parseJsonResponse(String jsonResult) {
        try {
            if (jsonResult == null || jsonResult.trim().isEmpty()) {
                logger.warn("Respuesta JSON vacía o nula");
                return DatabaseResponse.error("No se recibió respuesta del servidor");
            }

            return objectMapper.readValue(jsonResult, DatabaseResponse.class);
        } catch (JsonProcessingException e) {
            logger.error("Error al parsear respuesta JSON: {}", jsonResult, e);
            return DatabaseResponse.error("Error al procesar la respuesta del servidor");
        }
    }

    /**
     * Maneja excepciones de base de datos y extrae mensajes significativos.
     */
    private DatabaseResponse handleDatabaseException(DataAccessException e) {
        String errorMessage = e.getMessage();

        // Buscar códigos de error conocidos
        for (Map.Entry<String, String> entry : errorCodeMap.entrySet()) {
            if (errorMessage.contains(entry.getKey())) {
                return DatabaseResponse.error(entry.getValue());
            }
        }

        // Si no se encuentra un código específico, extraer mensaje de Oracle
        int startIndex = errorMessage.indexOf("ORA-");
        if (startIndex >= 0) {
            int endIndex = errorMessage.indexOf(":", startIndex);
            if (endIndex > startIndex) {
                String oraError = errorMessage.substring(startIndex, endIndex);
                return DatabaseResponse.error("Error de base de datos: " + oraError);
            }
        }

        return DatabaseResponse.error("Error de base de datos: " + errorMessage);
    }

    /**
     * Convierte un objeto a un tipo específico basado en el JsonNode.
     */
    public <T> T convertData(JsonNode jsonNode, Class<T> targetType) {
        try {
            return objectMapper.treeToValue(jsonNode, targetType);
        } catch (JsonProcessingException e) {
            logger.error("Error al convertir datos a {}: {}", targetType.getName(), e.getMessage(), e);
            throw new RuntimeException("Error al convertir datos: " + e.getMessage());
        }
    }
}