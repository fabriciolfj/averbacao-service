package com.github.fabriciolfj.consignado.controller.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ConsignadoResponse {

    private String code;
    @JsonProperty("prazo_contrato_dias")
    private int deadLine;
    @JsonProperty("data_vencimento")
    private LocalDate dueDate;
    private String status;
    @JsonProperty("parcela")
    private BigDecimal value;
}
