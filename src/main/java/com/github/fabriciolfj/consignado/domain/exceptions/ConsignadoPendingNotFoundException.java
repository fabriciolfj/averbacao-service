package com.github.fabriciolfj.consignado.domain.exceptions;

public class ConsignadoPendingNotFoundException extends RuntimeException {

    public ConsignadoPendingNotFoundException(final String msg) {
        super(msg);
    }
}
