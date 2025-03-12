package com.afsotec.repository;

import com.afsotec.model.Caja;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConsultaCajaRepository extends JpaRepository<Caja, Integer> {

    @Query(value =
            "SELECT CJ.EMPRESA_ID, CJ.SUCURSAL_ID, CJ.CAJA_ID, CJ.RESPONSABLE, CJ.USUARIO_ID, CJ.ESTATUS_CAJA, SC.SALDO_EFECTIVO " +
                    "FROM CAJA CJ " +
                    "INNER JOIN SALDO_CAJA SC ON SC.EMPRESA_ID = CJ.EMPRESA_ID AND SC.SUCURSAL_ID = CJ.SUCURSAL_ID AND SC.CAJA_ID = CJ.CAJA_ID " +
                    "WHERE CJ.EMPRESA_ID = :empresaId AND TRIM(CJ.USUARIO_ID) = :usuarioId",
            nativeQuery = true)
    List<Object[]> findCajasByUsuarioId(
            @Param("empresaId") Integer empresaId, // Cambiado de "empresa" a "empresaId"
            @Param("usuarioId") String usuarioId
    );

    // Método alternativo con LIKE para buscar de forma más flexible
    @Query(value =
            "SELECT CJ.EMPRESA_ID, CJ.SUCURSAL_ID, CJ.CAJA_ID, CJ.RESPONSABLE, CJ.USUARIO_ID, CJ.ESTATUS_CAJA, SC.SALDO_EFECTIVO " +
                    "FROM CAJA CJ " +
                    "INNER JOIN SALDO_CAJA SC ON SC.EMPRESA_ID = CJ.EMPRESA_ID AND SC.SUCURSAL_ID = CJ.SUCURSAL_ID AND SC.CAJA_ID = CJ.CAJA_ID " +
                    "WHERE CJ.EMPRESA_ID = :empresaId",
            nativeQuery = true)
    List<Object[]> findCajasByEmpresa(
            @Param("empresaId") Integer empresaId // Cambiado de "empresa" a "empresaId"
    );
}