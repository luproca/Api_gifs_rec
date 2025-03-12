package com.afsotec.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class RecaudacionRequest {

    @NotNull(message = "El ID de empresa es requerido")
    @JsonProperty("empresaId")
    private Integer empresaId;

    @NotNull(message = "El ID de cuenta es requerido")
    @JsonProperty("cuentaId")
    private Integer cuentaId;

    @NotNull(message = "El ID de transacción es requerido")
    @Pattern(regexp = "ADPV", message = "El ID de transacción debe ser ADPV")
    @JsonProperty("transaccionId")
    private String transaccionId;

    @NotNull(message = "El ID de concepto es requerido")
    @JsonProperty("conceptoId")
    private Integer conceptoId;

    @NotNull(message = "El valor es requerido")
    @Min(value = 0, message = "El valor debe ser mayor que cero")
    @JsonProperty("valor")
    private BigDecimal valor;

    @Size(max = 255, message = "La observación no puede exceder 255 caracteres")
    @JsonProperty("observacion")
    private String observacion;

    @Size(max = 50, message = "La referencia no puede exceder 50 caracteres")
    @JsonProperty("nreferencia")
    private String nreferencia;

    @NotNull(message = "El ID de caja es requerido")
    @JsonProperty("cajaId")
    private Integer cajaId;
}