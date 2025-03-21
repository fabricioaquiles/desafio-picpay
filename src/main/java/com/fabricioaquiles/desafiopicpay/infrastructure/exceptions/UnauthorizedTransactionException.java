package com.fabricioaquiles.desafiopicpay.infrastructure.exceptions;

public class UnauthorizedTransactionException extends RuntimeException{

    public UnauthorizedTransactionException(String message) {
        super(message);
    }
}
