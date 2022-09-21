package io.grumpyprogrammer.example.spring.cloud.contract.post;

public class NotFoundException extends RuntimeException {

    public NotFoundException(String message) {
        super(message);
    }

}
