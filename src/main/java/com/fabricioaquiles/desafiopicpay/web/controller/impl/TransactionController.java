package com.fabricioaquiles.desafiopicpay.web.controller.impl;

import com.fabricioaquiles.desafiopicpay.adapters.rest.mapper.TransactionMapper;
import com.fabricioaquiles.desafiopicpay.domain.service.TransferService;
import com.fabricioaquiles.desafiopicpay.web.controller.ITransactionController;
import com.fabricioaquiles.desafiopicpay.web.request.CreateTransactionRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/transfer")
public class TransactionController implements ITransactionController {

    private final TransferService transactionService;

    @PostMapping
    public ResponseEntity<Void> transfer(CreateTransactionRequest createTransactionRequest) {

        var createTransactionDto = TransactionMapper.toDto(createTransactionRequest);
        transactionService.processTransaction(createTransactionDto);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
