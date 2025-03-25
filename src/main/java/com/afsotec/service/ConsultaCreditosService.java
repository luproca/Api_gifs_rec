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
    public List<ConsultaCreditosResponse> consultarCreditos(Integer empresa, String identificacion) {
        List<Object[]> resultados = consultaCreditosRepository.findCreditosByIdentificacion(empresa, identificacion);
        List<ConsultaCreditosResponse> creditos = new ArrayList<>();

        for (Object[] resultado : resultados) {

            // Depuración: Imprimir valores antes de convertirlos
            for (int i = 0; i < resultado.length; i++) {
                System.out.println("Índice " + i + ": " + resultado[i] + " (Tipo: " + (resultado[i] != null ? resultado[i].getClass().getName() : "null") + ")");
            }

            ConsultaCreditosResponse response = new ConsultaCreditosResponse(
                    resultado[0] instanceof Number ? ((Number) resultado[0]).intValue() : Integer.parseInt(resultado[0].toString()),  // empresaId
                    resultado[1] != null ? resultado[1].toString() : "",  // nombreEmpresa
                    resultado[2] instanceof Number ? ((Number) resultado[2]).intValue() : Integer.parseInt(resultado[2].toString()),  // sucursalId
                    resultado[3] != null ? resultado[3].toString() : "",  // nombreSucursal
                    resultado[4] instanceof Number ? ((Number) resultado[4]).intValue() : Integer.parseInt(resultado[4].toString()),  // socioId
                    resultado[5] instanceof Number ? ((Number) resultado[5]).intValue() : Integer.parseInt(resultado[5].toString()),  // numeroCredito
                    resultado[6] != null ? resultado[6].toString() : "",  // identificacion
                    resultado[7] != null ? resultado[7].toString() : "",  // nombres
                    resultado[8] != null ? resultado[8].toString() : "",  // tipoCredito
                    resultado[9] != null ? resultado[9].toString() : "",  // descripcionCredito
                    resultado[10] != null ? resultado[10].toString() : "", // estatusCredito
                    resultado[11] instanceof Number ? new BigDecimal(resultado[11].toString()) : BigDecimal.ZERO, // saldoCapital
                    resultado[12] instanceof Number ? new BigDecimal(resultado[12].toString()) : BigDecimal.ZERO, // amortizacion
                    resultado[13] instanceof Number ? new BigDecimal(resultado[13].toString()) : BigDecimal.ZERO, // interes
                    resultado[14] instanceof Number ? new BigDecimal(resultado[14].toString()) : BigDecimal.ZERO, // mora
                    resultado[15] instanceof Number ? new BigDecimal(resultado[15].toString()) : BigDecimal.ZERO, // gestion
                    resultado[16] instanceof Number ? new BigDecimal(resultado[16].toString()) : BigDecimal.ZERO, // seguro
                    resultado[17] instanceof Number ? new BigDecimal(resultado[17].toString()) : BigDecimal.ZERO, // total
                    resultado[18] != null ? resultado[18].toString() : "",  // mail
                    resultado[19] != null ? resultado[19].toString() : "",  // celular
                    resultado[20] instanceof Number ? ((Number) resultado[20]).intValue() : 0,  // cuentaAhorroId
                    resultado[21] != null ? resultado[21].toString() : "",  // estatusCuenta
                    resultado[22] != null ? resultado[22].toString() : ""   // nombreProducto
            );

            creditos.add(response);
        }

        return creditos;
    }
}
