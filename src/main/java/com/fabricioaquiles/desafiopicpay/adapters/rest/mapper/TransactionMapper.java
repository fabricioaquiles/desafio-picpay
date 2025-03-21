package com.fabricioaquiles.desafiopicpay.adapters.rest.mapper;

import com.fabricioaquiles.desafiopicpay.application.dto.CreateTransactionDto;
import com.fabricioaquiles.desafiopicpay.web.request.CreateTransactionRequest;

public class TransactionMapper {
    public static CreateTransactionDto toDto(CreateTransactionRequest createTransactionRequest) {
        return new CreateTransactionDto(
                createTransactionRequest.value(),
                createTransactionRequest.payer(),
                createTransactionRequest.payee()
        );
    }
}
