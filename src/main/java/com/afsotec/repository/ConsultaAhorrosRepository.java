package com.afsotec.repository;

import com.afsotec.dto.ConsultaAhorrosResponse;
import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.StoredProcedureQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ConsultaAhorrosRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<ConsultaAhorrosResponse> consultaAhorros(Integer empresa, String identificacion) {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("SP_CONSULTA_AHORROS");

        // Registrar parámetros de entrada
        query.registerStoredProcedureParameter("par_empresa", Integer.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("par_identificacion", String.class, ParameterMode.IN);

        // Registrar el resultado como un REF CURSOR
        query.registerStoredProcedureParameter("result_cursor", Class.class, ParameterMode.REF_CURSOR);

        // Asignar valores a los parámetros
        query.setParameter("par_empresa", empresa);
        query.setParameter("par_identificacion", identificacion);

        // Ejecutar el procedimiento
        query.execute();

        // Obtener el resultado como una lista mapeada a ConsultaAhorrosResponse
        return query.getResultList();
    }
}