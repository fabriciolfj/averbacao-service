package com.github.fabriciolfj.consignado.domain.exceptions;

public class StatusNotFoundException extends RuntimeException {

    public StatusNotFoundException(final String describe) {
        super(describe);
    }
}
