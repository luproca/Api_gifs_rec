package com.afsotec.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Clase para mapear respuestas JSON de procedimientos almacenados.
 * Formato esperado: {"codigo":"true|false", "mensaje":"texto", "datos":{...}}
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class DatabaseResponse {

    @JsonProperty("codigo")
    private String codigo;

    @JsonProperty("mensaje")
    private String mensaje;

    @JsonProperty("datos")
    private JsonNode datos;

    /**
     * Verifica si la respuesta indica éxito.
     */
    public boolean isSuccess() {
        return "true".equals(codigo);
    }

    /**
     * Crea una respuesta de error con el mensaje proporcionado.
     */
    public static DatabaseResponse error(String errorMessage) {
        DatabaseResponse response = new DatabaseResponse();
        response.setCodigo("false");
        response.setMensaje(errorMessage);
        return response;
    }

    /**
     * Crea una respuesta de éxito con el mensaje y datos proporcionados.
     */
    public static DatabaseResponse success(String message, JsonNode data) {
        DatabaseResponse response = new DatabaseResponse();
        response.setCodigo("true");
        response.setMensaje(message);
        response.setDatos(data);
        return response;
    }
}