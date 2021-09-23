package com.github.fabriciolfj.consignado.business;

import com.github.fabriciolfj.consignado.domain.Consignado;

import java.util.List;

public interface ListConsignado {

    List<Consignado> findLastPending();
}
