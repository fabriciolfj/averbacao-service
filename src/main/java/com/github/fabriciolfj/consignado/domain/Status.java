package com.github.fabriciolfj.consignado.domain;

import com.github.fabriciolfj.consignado.domain.exceptions.StatusNotFoundException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.stream.Stream;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum Status {

    PENDING("pending", 0),
    PROCESSING("processing", 1),
    ACCEPT("accept", 2),
    REFUSED("refused", 3),
    ERROR("error", 4);

    private String describe;
    private int code;

    public static Status toEnum(final String describe) {
        return Stream.of(Status.values())
                .filter(v -> v.getDescribe().equalsIgnoreCase(describe))
                .findFirst()
                .orElseThrow(() -> new StatusNotFoundException("Status not found: " + describe));
    }

    public static Status toEnum(final int code) {
        return Stream.of(Status.values())
                .filter(v -> v.getCode() == code)
                .findFirst()
                .orElseThrow(() -> new StatusNotFoundException("Status not found: " + code));
    }
}
