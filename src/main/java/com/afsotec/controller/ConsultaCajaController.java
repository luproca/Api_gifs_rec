package com.afsotec.controller;

import com.afsotec.dto.ConsultaCajaRequest;
import com.afsotec.dto.ConsultaCajaResponse;
import com.afsotec.service.ConsultaCajaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cajas")
public class ConsultaCajaController {

    private static final Logger log = LoggerFactory.getLogger(ConsultaCajaController.class);

    private final ConsultaCajaService consultaCajaService;

    @Autowired
    public ConsultaCajaController(ConsultaCajaService consultaCajaService) {
        this.consultaCajaService = consultaCajaService;
    }

    @PostMapping("/consultar")
    public ResponseEntity<List<ConsultaCajaResponse>> consultarCajas(@RequestBody ConsultaCajaRequest request) {
        try {
            log.info("Recibida solicitud para consultar cajas: empresaId={}, usuarioId={}",
                    request.getEmpresaId(), request.getUsuarioId());

            List<ConsultaCajaResponse> resultado = consultaCajaService.consultarCajas(
                    request.getEmpresaId(), request.getUsuarioId());

            if (resultado.isEmpty()) {
                log.info("No se encontraron cajas para la consulta");
            } else {
                log.info("Se encontraron {} cajas para la consulta", resultado.size());
            }

            return ResponseEntity.ok(resultado);
        } catch (Exception e) {
            log.error("Error al consultar cajas: {}", e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}