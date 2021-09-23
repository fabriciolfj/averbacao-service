package com.github.fabriciolfj.consignado.gateway.provider.http.inss.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InssResponse {

    @JsonProperty("cliente")
    private String customer;
    @JsonProperty("reserva_aceita")
    private boolean accept;
}
