package com.github.fabriciolfj.consignado.gateway.provider.http.inss.mapper;

import com.github.fabriciolfj.consignado.domain.Averbacao;
import com.github.fabriciolfj.consignado.domain.Consignado;
import com.github.fabriciolfj.consignado.domain.Status;
import com.github.fabriciolfj.consignado.gateway.provider.http.inss.dto.InssRequest;
import com.github.fabriciolfj.consignado.gateway.provider.http.inss.dto.InssResponse;

public class InssDTOMapper {

    private InssDTOMapper() { }

    public static final InssRequest toRequest(final Consignado consignado) {
        return InssRequest
                .builder()
                .dueDate(consignado.getDueDate())
                .customer(consignado.getCustomer())
                .value(consignado.getValue())
                .contract(consignado.getDeadLine())
                .build();
    }

    public static final Averbacao toDomain(final InssResponse response, final String code) {
        return Averbacao
                .builder()
                .status(response.isAccept() ? Status.ACCEPT : Status.REFUSED)
                .code(code)
                .build();
    }

    public static final Averbacao toDomainError(final String msg, final String code) {
        return Averbacao.builder()
                .code(code)
                .describeError(msg)
                .status(Status.ERROR)
                .build();
    }
}
