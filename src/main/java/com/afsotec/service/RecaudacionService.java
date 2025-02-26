package com.afsotec.service;

import com.afsotec.dto.DatabaseResponse;
import com.afsotec.dto.RecaudacionRequest;
import com.afsotec.dto.RecaudacionResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

/**
 * Servicio para gestionar operaciones de recaudación.
 */
@Service
public class RecaudacionService {

    private static final Logger logger = LoggerFactory.getLogger(RecaudacionService.class);

    @Autowired
    private StoredProcedureService storedProcedureService;

    /**
     * Procesa una solicitud de recaudación llamando al procedimiento almacenado SP_RECAUDACION.
     *
     * @param request Datos de la solicitud de recaudación
     * @return Respuesta con el resultado de la operación
     */
    @Transactional
    public RecaudacionResponse procesarRecaudacion(RecaudacionRequest request) {
        logger.info("Procesando recaudación: empresaId={}, cuentaId={}, valor={}, cajaId={}",
                request.getEmpresaId(), request.getCuentaId(), request.getValor(), request.getCajaId());

        try {
            // Preparar parámetros para el procedimiento almacenado
            Map<String, Object> params = new HashMap<>();
            params.put("par_empresa_id", request.getEmpresaId());
            params.put("par_cuenta_id", request.getCuentaId());
            params.put("par_transaccion_id", request.getTransaccionId());
            params.put("par_concepto_id", request.getConceptoId());
            params.put("par_valor", request.getValor().doubleValue());
            params.put("par_observacion", request.getObservacion() != null ? request.getObservacion() : "");
            params.put("par_nreferencia", request.getNreferencia() != null ? request.getNreferencia() : "");
            params.put("par_caja_id", request.getCajaId());

            // Ejecutar el procedimiento almacenado
            DatabaseResponse dbResponse = storedProcedureService.executeStoredProcedure(
                    "SP_RECAUDACION", params, "json_param");

            // Convertir la respuesta de la base de datos a la respuesta de la API
            RecaudacionResponse response = new RecaudacionResponse();
            response.setCodigo(dbResponse.getCodigo());
            response.setMensaje(dbResponse.getMensaje());

            // Registrar el resultado
            logger.info("Resultado de recaudación: success={}, mensaje={}",
                    dbResponse.isSuccess(), dbResponse.getMensaje());

            return response;

        } catch (Exception e) {
            logger.error("Error no controlado al procesar recaudación: {}", e.getMessage(), e);

            RecaudacionResponse errorResponse = new RecaudacionResponse();
            errorResponse.setCodigo("false");
            errorResponse.setMensaje("Error interno al procesar la recaudación: " + e.getMessage());

            return errorResponse;
        }
    }

    /**
     * Consulta el estado de una transacción de recaudación.
     *
     * @param empresaId ID de la empresa
     * @param cuentaId ID de la cuenta
     * @param referencia Referencia de la transacción (opcional)
     * @return Respuesta con el resultado de la consulta
     */
    public RecaudacionResponse consultarTransaccion(Integer empresaId, Integer cuentaId, String referencia) {
        logger.info("Consultando transacción: empresaId={}, cuentaId={}, referencia={}",
                empresaId, cuentaId, referencia);

        try {
            // Aquí podrías implementar una llamada a un procedimiento almacenado
            // para consultar el estado de la transacción

            // Por ahora, simulamos una respuesta exitosa
            RecaudacionResponse response = new RecaudacionResponse();
            response.setCodigo("true");
            response.setMensaje("Consulta realizada correctamente");

            return response;

        } catch (Exception e) {
            logger.error("Error al consultar transacción: {}", e.getMessage(), e);

            RecaudacionResponse errorResponse = new RecaudacionResponse();
            errorResponse.setCodigo("false");
            errorResponse.setMensaje("Error al consultar la transacción: " + e.getMessage());

            return errorResponse;
        }
    }
}