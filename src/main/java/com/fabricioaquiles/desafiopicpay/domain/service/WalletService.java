package com.fabricioaquiles.desafiopicpay.domain.service;

import com.fabricioaquiles.desafiopicpay.domain.model.Wallet;
import com.fabricioaquiles.desafiopicpay.infrastructure.repository.WalletRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WalletService {

    private final WalletRepository walletRepository;

    public void saveWallet(Wallet wallet) {
        walletRepository.save(wallet);
    }
}
