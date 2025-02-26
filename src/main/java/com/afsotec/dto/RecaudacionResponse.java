package com.afsotec.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecaudacionResponse {
    private boolean success;
    private String message;
    private String jsonResult;

    // Constructor para caso de éxito
    public static RecaudacionResponse success(String jsonResult) {
        return new RecaudacionResponse(true, "Recaudación procesada correctamente", jsonResult);
    }

    // Constructor para caso de error
    public static RecaudacionResponse error(String errorMessage) {
        return new RecaudacionResponse(false, errorMessage, null);
    }
}