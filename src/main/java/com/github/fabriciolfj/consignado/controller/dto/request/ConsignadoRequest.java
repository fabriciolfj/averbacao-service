package com.github.fabriciolfj.consignado.controller.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class ConsignadoRequest {

    @JsonProperty("valor_parcela")
    @Positive(message = "Value must be greater than zero")
    @NotNull(message = "Value not null")
    private BigDecimal value;
    @NotNull(message = "Due date must be filled in")
    @JsonProperty("data_primeiro_vencimento")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate dueDate;
    @JsonProperty("prazo_contrato")
    @Positive(message = "Deadline must be greater than zero")
    private int deadLine;
    @NotBlank(message = "Customer not null or not blank")
    @JsonProperty("codigo_cliente")
    private String customer;
}
