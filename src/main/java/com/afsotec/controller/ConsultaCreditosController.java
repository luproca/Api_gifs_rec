package com.afsotec.controller;

import com.afsotec.dto.ConsultaCreditosRequest;
import com.afsotec.dto.ConsultaCreditosResponse;
import com.afsotec.service.ConsultaCreditosService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/creditos")
public class ConsultaCreditosController {

    private static final Logger logger = LoggerFactory.getLogger(ConsultaCreditosController.class);

    @Autowired
    private ConsultaCreditosService consultaCreditosService;

    @PostMapping("/consultar")
    public ResponseEntity<List<ConsultaCreditosResponse>> consultarCreditos(@RequestBody ConsultaCreditosRequest request) {
        logger.info("Consultando créditos para empresaId={}, identificación={}",
                request.getEmpresaId(), request.getIdentificacion());

        List<ConsultaCreditosResponse> resultados = consultaCreditosService.consultarCreditos(
                request.getEmpresaId(), request.getIdentificacion());

        if (resultados.isEmpty()) {
            logger.info("No se encontraron créditos para la consulta");
            return ResponseEntity.noContent().build();
        }

        logger.info("Se encontraron {} créditos", resultados.size());
        return ResponseEntity.ok(resultados);
    }
}