package com.afsotec.controller;

import com.afsotec.dto.RecaudacionRequest;
import com.afsotec.dto.RecaudacionResponse;
import com.afsotec.service.RecaudacionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

/**
 * Controlador para operaciones de recaudación.
 */
@RestController
@RequestMapping("/api/recaudacion")
@Tag(name = "Recaudación", description = "API para operaciones de recaudación")
public class RecaudacionController {

    private static final Logger logger = LoggerFactory.getLogger(RecaudacionController.class);

    @Autowired
    private RecaudacionService recaudacionService;

    /**
     * Procesa una solicitud de recaudación.
     *
     * @param request Datos de la solicitud
     * @return Respuesta con el resultado de la operación
     */
    @PostMapping("/procesar")
    @Operation(
            summary = "Procesar recaudación",
            description = "Realiza una operación de recaudación utilizando el procedimiento almacenado SP_RECAUDACION",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Operación procesada correctamente",
                            content = @Content(schema = @Schema(implementation = RecaudacionResponse.class))
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Error en los datos de la solicitud",
                            content = @Content(schema = @Schema(implementation = RecaudacionResponse.class))
                    ),
                    @ApiResponse(
                            responseCode = "500",
                            description = "Error interno del servidor",
                            content = @Content(schema = @Schema(implementation = RecaudacionResponse.class))
                    )
            }
    )
    public RecaudacionResponse procesarRecaudacion(@Valid @RequestBody RecaudacionRequest request) {
        logger.info("Recibida solicitud de recaudación: {}", request);

        // Validar que la transacción sea ADPV según el procedimiento
        if (!"ADPV".equals(request.getTransaccionId())) {
            logger.warn("Solicitud rechazada: transaccionId debe ser ADPV, recibido: {}", request.getTransaccionId());
            RecaudacionResponse errorResponse = new RecaudacionResponse();
            errorResponse.setCodigo("false");
            errorResponse.setMensaje("La transacción debe ser de tipo ADPV");
            return errorResponse;
        }

        // Procesar la recaudación
        return recaudacionService.procesarRecaudacion(request);
    }

    /**
     * Consulta el estado de una transacción.
     *
     * @param empresaId ID de la empresa
     * @param cuentaId ID de la cuenta
     * @param referencia Referencia de la transacción (opcional)
     * @return Respuesta con el resultado de la consulta
     */
    @GetMapping("/consultar")
    @Operation(
            summary = "Consultar estado de transacción",
            description = "Permite consultar el estado de una transacción de recaudación",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Consulta realizada correctamente",
                            content = @Content(schema = @Schema(implementation = RecaudacionResponse.class))
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Error en los parámetros de consulta",
                            content = @Content(schema = @Schema(implementation = RecaudacionResponse.class))
                    ),
                    @ApiResponse(
                            responseCode = "500",
                            description = "Error interno del servidor",
                            content = @Content(schema = @Schema(implementation = RecaudacionResponse.class))
                    )
            }
    )
    public RecaudacionResponse consultarTransaccion(
            @RequestParam Integer empresaId,
            @RequestParam Integer cuentaId,
            @RequestParam(required = false) String referencia) {

        logger.info("Consulta de transacción: empresaId={}, cuentaId={}, referencia={}",
                empresaId, cuentaId, referencia);

        return recaudacionService.consultarTransaccion(empresaId, cuentaId, referencia);
    }
}