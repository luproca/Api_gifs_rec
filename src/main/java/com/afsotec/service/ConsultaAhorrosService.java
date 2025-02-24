package com.afsotec.service;

import com.afsotec.dto.ConsultaAhorrosResponse;
import com.afsotec.repository.ConsultaAhorrosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ConsultaAhorrosService {

    @Autowired
    private ConsultaAhorrosRepository consultaAhorrosRepository;

    public List<ConsultaAhorrosResponse> consultaAhorros(Integer empresa, String identificacion) {
        List<String> resultados = consultaAhorrosRepository.consultaAhorros(empresa, identificacion);

        // Convertir cada línea en un objeto ConsultaAhorrosResponse
        return resultados.stream()
                .map(linea -> {
                    String[] campos = linea.split("\\|");
                    ConsultaAhorrosResponse response = new ConsultaAhorrosResponse();
                    response.setEmpresa(parseInt(campos[0]));
                    response.setNombreCortoEmpresa(campos[1]);
                    response.setSucursalId(parseInt(campos[2]));
                    response.setNombreSucursal(campos[3]);
                    response.setCodigo(parseInt(campos[4]));
                    response.setMensaje(campos[5]);
                    response.setNsocio(parseInt(campos[6]));
                    response.setIdentificacion(campos[7]);
                    response.setNombreCompleto(campos[8]);
                    response.setNcuenta(parseInt(campos[9]));
                    response.setIdProducto(parseInt(campos[10]));
                    response.setNProducto(campos[11]);
                    response.setTipoAhorro(campos[12]);
                    response.setEstatus(campos[13]);
                    response.setTitular(campos[14]);
                    response.setSTotal(parseBigDecimal(campos[15]));
                    response.setSaldoBloqueado(parseBigDecimal(campos[16]));
                    response.setSaldoTransito(parseBigDecimal(campos[17]));
                    response.setSDisponible(parseBigDecimal(campos[18]));
                    response.setCelular(campos[19]);
                    response.setMail(campos[20]);
                    return response;
                })
                .collect(Collectors.toList());
    }

    // Método para convertir String a Integer de manera segura
    private Integer parseInt(String value) {
        if (value == null || value.trim().isEmpty()) {
            return null; // O puedes devolver un valor por defecto, como 0
        }
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            System.err.println("Error al convertir a Integer: " + value);
            return null; // O puedes devolver un valor por defecto, como 0
        }
    }

    // Método para convertir String a BigDecimal de manera segura
    private BigDecimal parseBigDecimal(String value) {
        if (value == null || value.trim().isEmpty()) {
            return null; // O puedes devolver un valor por defecto, como BigDecimal.ZERO
        }
        try {
            // Reemplazar comas por puntos si es necesario
            String normalizedValue = value.replace(",", ".");
            return new BigDecimal(normalizedValue);
        } catch (NumberFormatException e) {
            System.err.println("Error al convertir a BigDecimal: " + value);
            return null; // O puedes devolver un valor por defecto, como BigDecimal.ZERO
        }
    }
}