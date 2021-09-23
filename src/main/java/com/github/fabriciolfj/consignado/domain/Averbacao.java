package com.github.fabriciolfj.consignado.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Averbacao {

    private String code;
    private Status status;
    private String describeError;
}
