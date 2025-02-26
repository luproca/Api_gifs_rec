package com.afsotec.controller;

import com.afsotec.dto.ConsultaCreditosRequest;
import com.afsotec.dto.ConsultaCreditosResponse;
import com.afsotec.service.ConsultaCreditosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/creditos")
public class ConsultaCreditosController {

    @Autowired
    private ConsultaCreditosService consultaCreditosService;

    @PostMapping("/consultar")
    public List<ConsultaCreditosResponse> consultarCreditos(@RequestBody ConsultaCreditosRequest request) {
        return consultaCreditosService.consultarCreditos(request.getEmpresaId(), request.getIdentificacion());
    }
}

