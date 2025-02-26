package com.afsotec.controller;

import com.afsotec.dto.RecaudacionRequest;
import com.afsotec.dto.RecaudacionResponse;
import com.afsotec.service.RecaudacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/recaudacion")
public class RecaudacionController {

    @Autowired
    private RecaudacionService recaudacionService;

    @PostMapping("/procesar")
    public ResponseEntity<RecaudacionResponse> procesarRecaudacion(@RequestBody RecaudacionRequest request) {
        try {
            // Validar datos de entrada
            if (request.getEmpresaId() == null || request.getCuentaId() == null ||
                    request.getTransaccionId() == null || request.getConceptoId() == null ||
                    request.getValor() == null || request.getCajaId() == null) {

                return ResponseEntity.badRequest().body(
                        RecaudacionResponse.error("Todos los campos obligatorios deben ser proporcionados")
                );
            }

            // Procesar la recaudación
            RecaudacionResponse response = recaudacionService.procesarRecaudacion(request);

            // Retornar respuesta apropiada según el resultado
            if (response.isSuccess()) {
                return ResponseEntity.ok(response);
            } else {
                return ResponseEntity.badRequest().body(response);
            }

        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(
                    RecaudacionResponse.error("Error en el servidor: " + e.getMessage())
            );
        }
    }
}