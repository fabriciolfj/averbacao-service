package com.github.fabriciolfj.consignado.business;

import com.github.fabriciolfj.consignado.domain.Averbacao;
import com.github.fabriciolfj.consignado.domain.Consignado;

import java.util.List;

public interface ProcessAverbacao {

    void processLegacy();
    List<Averbacao> processLastPendingConsignado(final List<Consignado> consignados);
}
