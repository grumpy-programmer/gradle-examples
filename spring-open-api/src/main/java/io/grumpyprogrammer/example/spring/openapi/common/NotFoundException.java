package io.grumpyprogrammer.example.spring.openapi.common;

import lombok.Getter;

public class NotFoundException extends RuntimeException {
    @Getter
    private final String id;

    public NotFoundException(String id, String message) {
        super(message);
        this.id = id;
    }
}
