package com.afsotec.service;

import com.afsotec.dto.RecaudacionRequest;
import com.afsotec.dto.RecaudacionResponse;
import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.StoredProcedureQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class RecaudacionService {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public RecaudacionResponse procesarRecaudacion(RecaudacionRequest request) {
        try {
            // Crear una consulta para el procedimiento almacenado
            StoredProcedureQuery query = entityManager.createStoredProcedureQuery("SP_RECAUDACION");

            // Registrar los parámetros de entrada y salida
            query.registerStoredProcedureParameter("par_empresa_id", Integer.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("par_cuenta_id", Integer.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("par_transaccion_id", String.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("par_concepto_id", Integer.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("par_valor", Double.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("par_observacion", String.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("par_nreferencia", String.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("par_caja_id", Integer.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("json_param", String.class, ParameterMode.OUT);

            // Asignar los valores a los parámetros de entrada
            query.setParameter("par_empresa_id", request.getEmpresaId());
            query.setParameter("par_cuenta_id", request.getCuentaId());
            query.setParameter("par_transaccion_id", request.getTransaccionId());
            query.setParameter("par_concepto_id", request.getConceptoId());
            query.setParameter("par_valor", request.getValor().doubleValue());
            query.setParameter("par_observacion", request.getObservacion());
            query.setParameter("par_nreferencia", request.getNreferencia());
            query.setParameter("par_caja_id", request.getCajaId());

            // Ejecutar el procedimiento almacenado
            query.execute();

            // Obtener el resultado del parámetro de salida
            String jsonResult = (String) query.getOutputParameterValue("json_param");

            // Devolver la respuesta exitosa
            return RecaudacionResponse.success(jsonResult);

        } catch (Exception e) {
            // En caso de error, registrar y devolver una respuesta de error
            System.err.println("Error al procesar la recaudación: " + e.getMessage());
            e.printStackTrace();
            return RecaudacionResponse.error("Error al procesar la recaudación: " + e.getMessage());
        }
    }
}