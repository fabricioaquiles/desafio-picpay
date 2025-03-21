package com.fabricioaquiles.desafiopicpay.domain.service;

import com.fabricioaquiles.desafiopicpay.application.dto.CreateTransactionDto;
import com.fabricioaquiles.desafiopicpay.domain.model.Transactions;
import com.fabricioaquiles.desafiopicpay.domain.model.User;
import com.fabricioaquiles.desafiopicpay.domain.model.enums.UserType;
import com.fabricioaquiles.desafiopicpay.infrastructure.exceptions.UnauthorizedTransactionException;
import com.fabricioaquiles.desafiopicpay.infrastructure.repository.TransactionsRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class TransferService {

    private final UserService userService;
    private final AuthorizationService authorizationService;
    private final WalletService walletService;
    private final TransactionsRepository transactionsRepository;
    private final NotificationService notificationService;

    @Transactional
    public void processTransaction(CreateTransactionDto createTransactionDto) {

        long startRequest = System.currentTimeMillis();

        log.info("1. Processing transaction");

        // Find the users
        var sender = userService.findUser(createTransactionDto.payer());
        var recipient = userService.findUser(createTransactionDto.payee());

        // Validate the transfer
        log.info("Validated users... validating transfer");
        validateTransfer(createTransactionDto, sender);

        // Perform the transfer
        log.info("Performing Transfer");
        sender.getWallet().setBalance(sender.getWallet().getBalance().subtract(createTransactionDto.value()));
        walletService.saveWallet(sender.getWallet());

        recipient.getWallet().setBalance(recipient.getWallet().getBalance().add(createTransactionDto.value()));
        walletService.saveWallet(recipient.getWallet());

        log.info("Transfer completed successfully");

        // Save transaction
        log.info("2. Saving transaction");
        Transactions transactions = Transactions.builder()
                .value(createTransactionDto.value())
                .payer(sender)
                .payee(recipient)
                .build();

        transactionsRepository.save(transactions);

        log.info("Trasaction saved successfully");


        // Send notification
        log.info("3. Sending notification");
        notificationService.sendNotification();

        // Calculating transfer request time
        long finishRequest = System.currentTimeMillis();
        System.out.println("POST /transfer request time: " + (finishRequest - startRequest) + " ms");

    }

    private void validateTransfer(CreateTransactionDto createTransactionDto, User sender) {

        if(sender.getUserType() == UserType.MERCHANT) throw new IllegalStateException("It is not possible to make a transfer with your user type");
        if(sender.getWallet().getBalance().compareTo(createTransactionDto.value()) < 0) throw new IllegalStateException("You don't have enough balance to carry out this transaction");
        authorizationService.isAuthorized();
    }
}
