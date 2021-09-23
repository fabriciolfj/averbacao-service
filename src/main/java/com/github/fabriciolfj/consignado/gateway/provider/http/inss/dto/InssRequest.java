package com.github.fabriciolfj.consignado.gateway.provider.http.inss.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
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
public class InssRequest {

    @JsonProperty("valor_parcela")
    private BigDecimal value;
    @JsonProperty("prazo_contrato")
    private int contract;
    @JsonProperty("data_primeiro_vencimento")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate dueDate;
    @JsonProperty("cliente")
    private String customer;
}
