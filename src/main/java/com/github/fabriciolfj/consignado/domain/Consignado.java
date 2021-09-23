package com.github.fabriciolfj.consignado.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Consignado {

    private String code;
    private String customer;
    private BigDecimal value;
    private int deadLine;
    private LocalDate dueDate;
    private Status status;
}
