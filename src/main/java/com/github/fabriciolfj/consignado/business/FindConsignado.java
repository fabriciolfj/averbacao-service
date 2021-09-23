package com.github.fabriciolfj.consignado.business;

import com.github.fabriciolfj.consignado.domain.Consignado;

public interface FindConsignado {

    Consignado find(final String code);
}
