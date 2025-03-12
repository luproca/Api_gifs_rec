package com.afsotec.repository;

import com.afsotec.dto.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.afsotec.dto.ConsultaAhorrosResponse;
import com.afsotec.model.Creditos;

import java.util.List;

@Repository
public interface ConsultaCreditosRepository extends JpaRepository<Creditos, Long> {

    @Query(value = "SELECT * FROM SALDO_RECAUDACION_FETCH WHERE EMPRESA_ID = :empresa AND IDENTIFICACION = :identificacion", nativeQuery = true)
    List<Object[]> findCreditosByIdentificacion(
            @Param("empresa") Integer empresa,
            @Param("identificacion") String identificacion
    );
}
