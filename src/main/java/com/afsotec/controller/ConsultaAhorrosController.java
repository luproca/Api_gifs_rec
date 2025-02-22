package com.afsotec.controller;

import com.afsotec.dto.ConsultaAhorrosRequest;
import com.afsotec.dto.ConsultaAhorrosResponse;
import com.afsotec.service.ConsultaAhorrosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/consulta-ahorros")
public class ConsultaAhorrosController {

    @Autowired
    private ConsultaAhorrosService consultaAhorrosService;

    @PostMapping
    public ResponseEntity<List<ConsultaAhorrosResponse>> consultaAhorros(@RequestBody ConsultaAhorrosRequest request) {
        Integer empresa = request.getEmpresa();
        String identificacion = request.getIdentificacion();

        List<ConsultaAhorrosResponse> resultados = consultaAhorrosService.consultaAhorros(empresa, identificacion);

        return ResponseEntity.ok(resultados);
    }
}