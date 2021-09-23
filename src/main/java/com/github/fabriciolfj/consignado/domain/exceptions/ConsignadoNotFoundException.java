package com.github.fabriciolfj.consignado.domain.exceptions;

public class ConsignadoNotFoundException extends RuntimeException {

    public ConsignadoNotFoundException(final String msg) {
        super(msg);
    }
}
