package com.afsotec.service;

import com.afsotec.repository.ConsultaCajaRepository;
import com.afsotec.dto.ConsultaCajaResponse;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class ConsultaCajaService {

    @Autowired
    private ConsultaCajaRepository consultaCajaRepository;

    @Transactional
    public List<ConsultaCajaResponse> consultarCajas(Integer empresaId, String usuarioId) {
        System.out.println("Consultando cajas con empresaId: " + empresaId + ", usuarioId: '" + usuarioId + "'");

        // Aseguramos que el usuarioId esté correctamente formateado para la consulta
        String usuarioIdLimpio = usuarioId.trim();

        List<Object[]> resultados = consultaCajaRepository.findCajasByUsuarioId(empresaId, usuarioIdLimpio);
        System.out.println("Resultados encontrados: " + resultados.size());

        List<ConsultaCajaResponse> cajas = new ArrayList<>();

        for (Object[] resultado : resultados) {
            try {
                ConsultaCajaResponse response = new ConsultaCajaResponse(
                        ((Number) resultado[0]).intValue(),  // empresaId
                        ((Number) resultado[1]).intValue(),  // sucursalId
                        ((Number) resultado[2]).intValue(),  // cajaId
                        resultado[3] != null ? resultado[3].toString() : "",  // responsable
                        resultado[4] != null ? resultado[4].toString().trim() : "",  // usuarioId
                        resultado[5] != null ? resultado[5].toString() : "",  // estatusCaja
                        resultado[6] != null ? new BigDecimal(resultado[6].toString()) : BigDecimal.ZERO  // saldoEfectivo
                );
                cajas.add(response);
                System.out.println("Registro procesado: " + response);
            } catch (Exception e) {
                System.err.println("Error procesando registro: " + e.getMessage());
            }
        }

        return cajas;
    }

    @Transactional
    public List<ConsultaCajaResponse> consultarCajasPorEmpresa(Integer empresaId) {
        System.out.println("Consultando cajas por empresaId: " + empresaId);

        List<Object[]> resultados = consultaCajaRepository.findCajasByEmpresa(empresaId);
        System.out.println("Resultados encontrados: " + resultados.size());

        List<ConsultaCajaResponse> cajas = new ArrayList<>();

        for (Object[] resultado : resultados) {
            try {
                ConsultaCajaResponse response = new ConsultaCajaResponse(
                        ((Number) resultado[0]).intValue(),  // empresaId
                        ((Number) resultado[1]).intValue(),  // sucursalId
                        ((Number) resultado[2]).intValue(),  // cajaId
                        resultado[3] != null ? resultado[3].toString() : "",  // responsable
                        resultado[4] != null ? resultado[4].toString().trim() : "",  // usuarioId
                        resultado[5] != null ? resultado[5].toString() : "",  // estatusCaja
                        resultado[6] != null ? new BigDecimal(resultado[6].toString()) : BigDecimal.ZERO  // saldoEfectivo
                );
                cajas.add(response);
                System.out.println("Registro procesado: " + response);
            } catch (Exception e) {
                System.err.println("Error procesando registro: " + e.getMessage());
            }
        }

        return cajas;
    }
}