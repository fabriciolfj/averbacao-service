package com.github.fabriciolfj.consignado.business.usecase;

import com.github.fabriciolfj.consignado.business.ListConsignado;
import com.github.fabriciolfj.consignado.business.ProcessAverbacao;
import com.github.fabriciolfj.consignado.business.UpdateAverbacaoConsignado;
import com.github.fabriciolfj.consignado.domain.Consignado;
import com.github.fabriciolfj.consignado.domain.exceptions.ConsignadoPendingNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ff4j.FF4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import static com.github.fabriciolfj.consignado.constants.Constants.LEGACY_INSS_ENABLE;

@Slf4j
@Component
@RequiredArgsConstructor
public class AverbacaoCase {

    private final ProcessAverbacao processAverbacao;
    private final UpdateAverbacaoConsignado updateAverbacaoConsignado;
    private final ListConsignado listConsignado;
    private final FF4j ff4j;

    public void execute() {
        CompletableFuture.runAsync(() -> processing())
                .whenComplete((v, e) -> {
                   if (e != null) {
                       log.error("Fail prossing. Details: {}", e.getMessage());
                   }
                });
    }

    private void processing() {
        if (ff4j.check(LEGACY_INSS_ENABLE)) {
            processAverbacao.processLegacy();
            return;
        }

        processConsignadosPending();
    }

    private void processConsignadosPending() {
        final var consignados = listConsignado.findLastPending();

        if (consignados.isEmpty()) {
            throw new ConsignadoPendingNotFoundException("Consignados pending not found");
        }

        log.info("Processing averbacao: {}", consignados.size());
        processAverbacao(consignados);
    }

    private void processAverbacao(final List<Consignado> consignados) {
        final var averbacoes = processAverbacao.processLastPendingConsignado(consignados);
        log.info("Total annotations: {}", averbacoes.size());

        updateAverbacaoConsignado.execute(averbacoes);
    }
}
