package com.github.fabriciolfj.consignado.business;

import com.github.fabriciolfj.consignado.domain.Averbacao;

import java.util.List;

public interface UpdateAverbacaoConsignado {

    void execute(final List<Averbacao> averbacoes);
}
