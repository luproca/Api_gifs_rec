package com.afsotec.repository;

import com.afsotec.dto.ConsultaTransaccionesResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;

@Repository
public class ConsultaTransaccionesRepository {
    private static final Logger logger = Logger.getLogger(ConsultaTransaccionesRepository.class.getName());

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<ConsultaTransaccionesResponse> consultarTransaccionesDiaActual(Integer empresaId, Integer cajaId) {
        String sql = "SELECT " +
                "EMPRESA_ID, " +
                "SUCURSAL_ID, " +
                "CAJA_ID, " +
                "MOVIMIENTO_CAJA_ID, " +
                "FECHA, " +
                "HORA, " +
                "VALOR_EFECTIVO AS EFECTIVO, " +
                "TOTAL_TRANSACCION AS TOTAL, " +
                "TRANSACCION_SISTEMA_ID, " +
                "DESCRIPCION_TRANSACCION AS TRANSACCION, " +
                "SOCIO_ID AS NSOCIO, " +
                "CUENTA_AHORRO_ID AS CUENTA, " +
                "PERSONERIA, " +
                "TIPO_DOCUMENTO, " +
                "DOCUMENTO_IDENTIFICACION AS IDENTIFICACION, " +
                "CASE " +
                "    WHEN PERSONERIA IN ('J', 'H') THEN RAZON_SOCIAL " +
                "    WHEN PERSONERIA = 'N' THEN NOMBRE || ' ' || APELLIDO " +
                "    ELSE NULL " +
                "END AS NOMBRE_COMPLETO " +
                "FROM MOVIMIENTO_CAJA_FETCH " +
                "WHERE EMPRESA_ID = ? AND CAJA_ID = ? AND TRUNC(FECHA) = TRUNC(SYSDATE)";

        logger.info("Ejecutando consulta para empresaid " + empresaId + " y caja " + cajaId + " con fecha actual (SYSDATE)");

        return jdbcTemplate.query(
                sql,
                new TransaccionesRowMapper(),
                empresaId, cajaId
        );
    }

    private static class TransaccionesRowMapper implements RowMapper<ConsultaTransaccionesResponse> {
        @Override
        public ConsultaTransaccionesResponse mapRow(ResultSet rs, int rowNum) throws SQLException {
            ConsultaTransaccionesResponse response = new ConsultaTransaccionesResponse();

            try {
                // Manejo seguro de tipos de datos
                response.setEmpresaId(getIntegerSafely(rs, "EMPRESA_ID"));
                response.setSucursalId(getIntegerSafely(rs, "SUCURSAL_ID"));
                response.setCajaId(getIntegerSafely(rs, "CAJA_ID"));
                response.setMovimientoCajaId(getIntegerSafely(rs, "MOVIMIENTO_CAJA_ID"));

                // Fechas y horas
                response.setFecha(rs.getDate("FECHA") != null ? rs.getDate("FECHA").toLocalDate() : null);
                response.setHora(rs.getTime("HORA") != null ? rs.getTime("HORA").toLocalTime() : null);

                // Valores numéricos
                response.setEfectivo(getBigDecimalSafely(rs, "EFECTIVO"));
                response.setTotal(getBigDecimalSafely(rs, "TOTAL"));
                response.setTransaccionSistemaId(getIntegerSafely(rs, "TRANSACCION_SISTEMA_ID"));

                // Strings
                response.setTransaccion(rs.getString("TRANSACCION"));
                response.setNSocio(getIntegerSafely(rs, "NSOCIO"));
                response.setCuenta(getIntegerSafely(rs, "CUENTA"));
                response.setPersoneria(rs.getString("PERSONERIA"));
                response.setTipoDocumento(rs.getString("TIPO_DOCUMENTO"));
                response.setIdentificacion(rs.getString("IDENTIFICACION"));
                response.setNombreCompleto(rs.getString("NOMBRE_COMPLETO"));

            } catch (SQLException e) {
                Logger.getLogger(TransaccionesRowMapper.class.getName()).severe(
                        "Error al mapear fila: " + e.getMessage());
                throw e;
            }

            return response;
        }

        // Método para obtener Integer de manera segura
        private Integer getIntegerSafely(ResultSet rs, String columnName) throws SQLException {
            try {
                Object value = rs.getObject(columnName);
                if (value == null) {
                    return null;
                }

                if (value instanceof Integer) {
                    return (Integer) value;
                } else if (value instanceof Number) {
                    return ((Number) value).intValue();
                } else if (value instanceof String) {
                    String strValue = (String) value;
                    if (strValue.isEmpty()) {
                        return null;
                    }
                    try {
                        return Integer.parseInt(strValue.trim());
                    } catch (NumberFormatException e) {
                        Logger.getLogger(TransaccionesRowMapper.class.getName()).warning(
                                "No se pudo convertir la cadena a entero: " + strValue);
                        return null;
                    }
                }
                return null;
            } catch (SQLException e) {
                Logger.getLogger(TransaccionesRowMapper.class.getName()).warning(
                        "Error al obtener valor entero para columna " + columnName + ": " + e.getMessage());
                return null;
            }
        }

        // Método para obtener BigDecimal de manera segura
        private BigDecimal getBigDecimalSafely(ResultSet rs, String columnName) throws SQLException {
            try {
                BigDecimal value = rs.getBigDecimal(columnName);
                return value;
            } catch (SQLException e) {
                Logger.getLogger(TransaccionesRowMapper.class.getName()).warning(
                        "Error al obtener valor decimal para columna " + columnName + ": " + e.getMessage());
                return null;
            }
        }
    }
}