package com.afsotec.controller;

import com.afsotec.dto.ConsultaCajaRequest;
import com.afsotec.dto.ConsultaCajaResponse;
import com.afsotec.service.ConsultaCajaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cajas")
public class ConsultaCajaController {

    @Autowired
    private ConsultaCajaService consultaCajaService;

    @PostMapping("/consultar")
    public List<ConsultaCajaResponse> consultarCajas(@RequestBody ConsultaCajaRequest request) {
        System.out.println("Recibida solicitud para consultar cajas: " + request.getEmpresaId() + ", " + request.getUsuarioId());
        return consultaCajaService.consultarCajas(request.getEmpresaId(), request.getUsuarioId());
    }
}