package com.afsotec.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class DatabaseResponse {

    @JsonProperty("estado")  // Cambiado de "codigo" a "estado"
    private Boolean estado;  // Cambiado de String a Boolean

    @JsonProperty("message") // Cambiado de "mensaje" a "message"
    private String mensaje;  // El nombre del campo se mantiene igual para compatibilidad

    @JsonProperty("datos")
    private JsonNode datos;

    /**
     * Verifica si la respuesta indica éxito.
     */
    public boolean isSuccess() {
        return estado != null && estado; // Cambio para evaluar el boolean directamente
    }

    /**
     * Obtiene el código como string para compatibilidad con la interfaz existente
     */
    public String getCodigo() {
        return estado != null && estado ? "true" : "false";
    }

    /**
     * Crea una respuesta de error con el mensaje proporcionado.
     */
    public static DatabaseResponse error(String errorMessage) {
        DatabaseResponse response = new DatabaseResponse();
        response.setEstado(false);
        response.setMensaje(errorMessage);
        return response;
    }

    /**
     * Crea una respuesta de éxito con el mensaje y datos proporcionados.
     */
    public static DatabaseResponse success(String message, JsonNode data) {
        DatabaseResponse response = new DatabaseResponse();
        response.setEstado(true);
        response.setMensaje(message);
        response.setDatos(data);
        return response;
    }
}