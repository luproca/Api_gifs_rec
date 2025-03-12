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

        // Si no se proporciona un request, crear uno con valores por defecto
        if (request == null) {
            request = ConsultaTransaccionesRequest.builder()
                    .empresaId(1)
                    .cajaId(1)
                    .build();
        }

        logger.info("Recibida solicitud POST para consultar transacciones: " + request);

        List<ConsultaTransaccionesResponse> transacciones = consultaTransaccionesService.consultarTransaccionesDiaActual(request);

        logger.info("Se encontraron " + transacciones.size() + " transacciones");

        if (transacciones.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(transacciones, HttpStatus.OK);
    }

    @GetMapping("/consultar")
    public ResponseEntity<List<ConsultaTransaccionesResponse>> consultarTransaccionesDefault() {
        // Consulta con valores por defecto (Empresa 1, Caja 1)
        ConsultaTransaccionesRequest request = ConsultaTransaccionesRequest.builder()
                .empresaId(1)
                .cajaId(1)
                .build();

        logger.info("Recibida solicitud GET para consultar transacciones con valores por defecto");

        List<ConsultaTransaccionesResponse> transacciones = consultaTransaccionesService.consultarTransaccionesDiaActual(request);

        logger.info("Se encontraron " + transacciones.size() + " transacciones");

        if (transacciones.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(transacciones, HttpStatus.OK);
    }

    @GetMapping("/consultar/{empresaId}/{cajaId}")
    public ResponseEntity<List<ConsultaTransaccionesResponse>> consultarTransaccionesPorCaja(
            @PathVariable Integer empresaId,
            @PathVariable Integer cajaId) {

        logger.info("Recibida solicitud GET para consultar transacciones - Empresa: " +
                empresaId + ", Caja: " + cajaId);

        ConsultaTransaccionesRequest request = ConsultaTransaccionesRequest.builder()
                .empresaId(empresaId)
                .cajaId(cajaId)
                .build();

        List<ConsultaTransaccionesResponse> transacciones = consultaTransaccionesService.consultarTransaccionesDiaActual(request);

        logger.info("Se encontraron " + transacciones.size() + " transacciones");

        if (transacciones.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(transacciones, HttpStatus.OK);
    }
}