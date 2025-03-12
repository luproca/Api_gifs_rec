package com.afsotec.service;

import com.afsotec.dto.ConsultaTransaccionesRequest;
import com.afsotec.dto.ConsultaTransaccionesResponse;
import com.afsotec.repository.ConsultaTransaccionesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class ConsultaTransaccionesService {
    private static final Logger logger = Logger.getLogger(ConsultaTransaccionesService.class.getName());

    @Autowired
    private ConsultaTransaccionesRepository consultaTransaccionesRepository;

    public List<ConsultaTransaccionesResponse> consultarTransaccionesDiaActual(ConsultaTransaccionesRequest request) {
        // Usando valores por defecto si no se proporcionan
        Integer empresaId = request.getEmpresaId() != null ? request.getEmpresaId() : 1;
        Integer cajaId = request.getCajaId() != null ? request.getCajaId() : 1;

        logger.info("Consultando transacciones del día actual para Empresa: " + empresaId + ", Caja: " + cajaId);

        return consultaTransaccionesRepository.consultarTransaccionesDiaActual(empresaId, cajaId);
    }
}