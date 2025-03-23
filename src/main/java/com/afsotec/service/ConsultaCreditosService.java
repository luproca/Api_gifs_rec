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
                    "",  // nombreSucursal - no existe en la vista
                    resultado[3] instanceof Number ? ((Number) resultado[3]).intValue() : Integer.parseInt(resultado[3].toString()),  // socioId
                    resultado[4] instanceof Number ? ((Number) resultado[4]).intValue() : Integer.parseInt(resultado[4].toString()),  // numeroCredito
                    resultado[5] != null ? resultado[5].toString() : "",  // identificacion
                    resultado[6] != null ? resultado[6].toString() : "",  // nombres
                    resultado[7] != null ? resultado[7].toString() : "",  // tipoCredito
                    resultado[8] != null ? resultado[8].toString() : "",  // descripcionCredito
                    resultado[9] != null ? resultado[9].toString() : "", // estatusCredito
                    resultado[10] instanceof Number ? new BigDecimal(resultado[10].toString()) : BigDecimal.ZERO, // saldoCapital
                    resultado[11] instanceof Number ? new BigDecimal(resultado[11].toString()) : BigDecimal.ZERO, // amortizacion
                    resultado[12] instanceof Number ? new BigDecimal(resultado[12].toString()) : BigDecimal.ZERO, // interes
                    resultado[13] instanceof Number ? new BigDecimal(resultado[13].toString()) : BigDecimal.ZERO, // mora
                    resultado[14] instanceof Number ? new BigDecimal(resultado[14].toString()) : BigDecimal.ZERO, // gestion
                    resultado[15] instanceof Number ? new BigDecimal(resultado[15].toString()) : BigDecimal.ZERO, // seguro
                    resultado[16] instanceof Number ? new BigDecimal(resultado[16].toString()) : BigDecimal.ZERO, // total
                    resultado[17] != null ? resultado[17].toString() : "",  // mail
                    resultado[18] != null ? resultado[18].toString() : "",  // celular
                    resultado[19] instanceof Number ? ((Number) resultado[19]).intValue() : 0,  // cuentaAhorroId
                    resultado[20] != null ? resultado[20].toString() : "",  // estatusCuenta
                    resultado[21] != null ? resultado[21].toString() : ""   // nombreProducto
            );

            creditos.add(response);
        }

        return creditos;
    }
}
