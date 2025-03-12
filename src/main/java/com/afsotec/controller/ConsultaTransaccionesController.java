package com.afsotec.controller;

import com.afsotec.dto.ConsultaTransaccionesRequest;
import com.afsotec.dto.ConsultaTransaccionesResponse;
import com.afsotec.service.ConsultaTransaccionesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/transacciones")
public class ConsultaTransaccionesController {
    private static final Logger logger = Logger.getLogger(ConsultaTransaccionesController.class.getName());

    @Autowired
    private ConsultaTransaccionesService consultaTransaccionesService;

    @PostMapping("/consultar")
    public ResponseEntity<List<ConsultaTransaccionesResponse>> consultarTransacciones(
            @RequestBody(required = false) ConsultaTransaccionesRequest request) {


        logger.info("Recibida solicitud para consultar transacciones: " + request);

        List<ConsultaTransaccionesResponse> transacciones = consultaTransaccionesService.consultarTransaccionesDiaActual(request);

        logger.info("Se encontraron " + transacciones.size() + " transacciones");

        if (transacciones.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(transacciones, HttpStatus.OK);
    }
}