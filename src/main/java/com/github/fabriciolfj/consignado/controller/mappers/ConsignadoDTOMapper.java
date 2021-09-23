package com.github.fabriciolfj.consignado.controller.mappers;

import com.github.fabriciolfj.consignado.controller.dto.request.ConsignadoRequest;
import com.github.fabriciolfj.consignado.controller.dto.response.ConsignadoResponse;
import com.github.fabriciolfj.consignado.domain.Consignado;
import com.github.fabriciolfj.consignado.domain.Status;
import org.springframework.util.Assert;

import java.time.LocalDate;
import java.util.UUID;

public class ConsignadoDTOMapper {

    private ConsignadoDTOMapper() { }

    public static Consignado toDomain(final ConsignadoRequest request) {
        Assert.notNull(request, "Request cannot be null");
        Assert.notNull(request.getDueDate(), "Due date cannot be null");
        Assert.notNull(request.getCustomer(), "Customer cannot be null");
        Assert.notNull(request.getValue(), "Value cannot be null");
        Assert.isTrue(request.getDueDate().isAfter(LocalDate.now()), "Date invalid");

        return Consignado.builder()
                .code(UUID.randomUUID().toString())
                .customer(request.getCustomer())
                .deadLine(request.getDeadLine())
                .dueDate(request.getDueDate())
                .value(request.getValue())
                .status(Status.PENDING)
                .build();
    }

    public static ConsignadoResponse toResponse(final Consignado consignado) {
        return ConsignadoResponse.builder()
                .code(consignado.getCode())
                .deadLine(consignado.getDeadLine())
                .dueDate(consignado.getDueDate())
                .status(consignado.getStatus().getDescribe())
                .value(consignado.getValue())
                .build();
    }
}
