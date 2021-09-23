package com.github.fabriciolfj.consignado.gateway.provider;

import com.github.fabriciolfj.consignado.business.ProcessAverbacao;
import com.github.fabriciolfj.consignado.domain.Averbacao;
import com.github.fabriciolfj.consignado.domain.Consignado;
import com.github.fabriciolfj.consignado.gateway.provider.file.InssLegacyProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class AverbacaoProvider implements ProcessAverbacao {

    private final InssProvider inssProvider;
    private final InssLegacyProvider inssLegacyProvider;

    @Override
    public void processLegacy() {
        inssLegacyProvider.execute();
    }

    @Override
    public List<Averbacao> processLastPendingConsignado(final List<Consignado> consignados) {
        return consignados
                .parallelStream()
                .map(inssProvider::execute)
                .collect(Collectors.toList());
    }
}
