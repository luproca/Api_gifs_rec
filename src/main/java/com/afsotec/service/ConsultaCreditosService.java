package com.afsotec.service;

import com.afsotec.repository.ConsultaCreditosRepository;
import com.afsotec.dto.ConsultaCreditosResponse;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class ConsultaCreditosService {

    @Autowired
    private ConsultaCreditosRepository consultaCreditosRepository;

    @Transactional
    public List<ConsultaCreditosResponse> consultarCreditos(Integer empresaId, String identificacion) {
        List<Object[]> resultados = consultaCreditosRepository.findCreditosByIdentificacion(empresaId, identificacion);
        List<ConsultaCreditosResponse> creditos = new ArrayList<>();

        for (Object[] resultado : resultados) {
            ConsultaCreditosResponse response = new ConsultaCreditosResponse(
                    ((Number) resultado[0]).intValue(),  // empresaId
                    resultado[1] != null ? resultado[1].toString() : "",  // nombreEmpresa
                    ((Number) resultado[2]).intValue(),  // sucursalId
                    resultado[3] != null ? resultado[3].toString() : "",  // nombreSucursal
                    ((Number) resultado[4]).intValue(),  // socioId
                    ((Number) resultado[5]).intValue(),  // numeroCredito
                    resultado[6] != null ? resultado[6].toString() : "",  // identificacion
                    resultado[7] != null ? resultado[7].toString() : "",  // nombres
                    resultado[8] != null ? resultado[8].toString() : "",  // tipoCredito
                    resultado[9] != null ? resultado[9].toString() : "",  // descripcionCredito
                    resultado[10] != null ? resultado[10].toString() : "", // estatusCredito
                    resultado[11] != null ? new BigDecimal(resultado[11].toString()) : BigDecimal.ZERO, // saldoCapital
                    resultado[12] != null ? new BigDecimal(resultado[12].toString()) : BigDecimal.ZERO, // amortizacion
                    resultado[13] != null ? new BigDecimal(resultado[13].toString()) : BigDecimal.ZERO, // interes
                    resultado[14] != null ? new BigDecimal(resultado[14].toString()) : BigDecimal.ZERO, // mora
                    resultado[15] != null ? new BigDecimal(resultado[15].toString()) : BigDecimal.ZERO, // gestion
                    resultado[16] != null ? new BigDecimal(resultado[16].toString()) : BigDecimal.ZERO, // seguro
                    resultado[17] != null ? new BigDecimal(resultado[17].toString()) : BigDecimal.ZERO, // total
                    resultado[18] != null ? resultado[18].toString() : "",  // mail
                    resultado[19] != null ? resultado[19].toString() : "",  // celular
                    ((Number) resultado[20]).intValue(),  // cuentaAhorroId
                    resultado[21] != null ? resultado[21].toString() : "",  // estatusCuenta
                    resultado[22] != null ? resultado[22].toString() : ""   // nombreProducto
            );
            creditos.add(response);
        }

        return creditos;
    }
}
