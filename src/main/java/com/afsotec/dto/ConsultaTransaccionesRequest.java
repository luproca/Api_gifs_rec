package com.afsotec.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ConsultaTransaccionesRequest {
    @Schema(description = "ID de la empresa", required = true, example = "1")
    private Integer empresaId;

    @Schema(description = "ID de la caja", required = true, example = "1")
    private Integer cajaId;

}