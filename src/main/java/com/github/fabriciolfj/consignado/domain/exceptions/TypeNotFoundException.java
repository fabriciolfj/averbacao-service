package com.github.fabriciolfj.consignado.domain.exceptions;

public class TypeNotFoundException extends RuntimeException {

    public TypeNotFoundException(final String describe) {
        super(describe);
    }
}
