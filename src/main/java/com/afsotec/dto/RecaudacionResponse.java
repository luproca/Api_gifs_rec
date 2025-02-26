package com.afsotec.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecaudacionResponse {
    @JsonProperty("codigo")
    private String codigo;

    @JsonProperty("mensaje")
    private String mensaje;

    @JsonIgnore
    private String jsonResult;

    @JsonIgnore
    private Integer movimientoId;

    private static final ObjectMapper objectMapper = new ObjectMapper();

    // Constructor para caso de éxito
    public static RecaudacionResponse success(String jsonResult) {
        RecaudacionResponse response = new RecaudacionResponse();
        response.setCodigo("true");
        response.setMensaje("Ejecuta correctamente");
        response.setJsonResult(jsonResult);

        // Intentar extraer más información del JSON si es posible
        try {
            JsonNode jsonNode = objectMapper.readTree(jsonResult);
            if (jsonNode.has("movimientoId")) {
                response.setMovimientoId(jsonNode.get("movimientoId").asInt());
            }
        } catch (Exception e) {
            // Si no se puede parsear, ignoramos este paso
        }

        return response;
    }

    // Constructor para caso de error
    public static RecaudacionResponse error(String errorMessage) {
        RecaudacionResponse response = new RecaudacionResponse();
        response.setCodigo("false");
        response.setMensaje(errorMessage);
        return response;
    }

    // Método para personalizar la respuesta con detalles adicionales
    public static RecaudacionResponse withDetails(boolean success, String message, String jsonResult) {
        RecaudacionResponse response = new RecaudacionResponse();
        response.setCodigo(success ? "true" : "false");
        response.setMensaje(message);
        response.setJsonResult(jsonResult);
        return response;
    }
}