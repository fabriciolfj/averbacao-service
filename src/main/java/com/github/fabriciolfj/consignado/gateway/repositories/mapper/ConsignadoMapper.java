package com.github.fabriciolfj.consignado.gateway.repositories.mapper;

import com.github.fabriciolfj.consignado.domain.Consignado;
import com.github.fabriciolfj.consignado.domain.Status;
import com.github.fabriciolfj.consignado.gateway.repositories.entities.ConsignadoEntity;

public class ConsignadoMapper {

    private ConsignadoMapper () {}

    public static ConsignadoEntity toEntity(final Consignado consignado) {
        return ConsignadoEntity
                .builder()
                .code(consignado.getCode())
                .customer(consignado.getCustomer())
                .deadLine(consignado.getDeadLine())
                .dueDate(consignado.getDueDate())
                .status(consignado.getStatus().getCode())
                .value(consignado.getValue())
                .build();
    }

    public static Consignado toDomain(final ConsignadoEntity entity) {
        return Consignado
                .builder()
                .dueDate(entity.getDueDate())
                .code(entity.getCode())
                .status(Status.toEnum(entity.getStatus()))
                .value(entity.getValue())
                .deadLine(entity.getDeadLine())
                .customer(entity.getCustomer())
                .build();
    }
}
