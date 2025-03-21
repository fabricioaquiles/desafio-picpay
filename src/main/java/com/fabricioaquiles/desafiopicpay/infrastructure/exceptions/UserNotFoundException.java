package com.fabricioaquiles.desafiopicpay.infrastructure.exceptions;

public class UserNotFoundException extends RuntimeException{

    public UserNotFoundException(String message) {
        super(message);
    }
}
