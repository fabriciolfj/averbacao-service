package com.github.fabriciolfj.consignado.gateway.provider;

import com.github.fabriciolfj.consignado.domain.Averbacao;
import com.github.fabriciolfj.consignado.domain.Consignado;
import com.github.fabriciolfj.consignado.gateway.provider.http.inss.InssClient;
import com.github.fabriciolfj.consignado.gateway.provider.http.inss.mapper.InssDTOMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class InssProvider {

    private final InssClient inssClient;

    public Averbacao execute(final Consignado consignado) {
        try {
            final var response = inssClient.requestReserva(InssDTOMapper.toRequest(consignado));
            return InssDTOMapper.toDomain(response, consignado.getCode());
        } catch (Exception e) {
            log.error("Fail request balance, consignado code: {}", consignado.getCode());
            return InssDTOMapper.toDomainError(e.getMessage(), consignado.getCode());
        }
    }
}
