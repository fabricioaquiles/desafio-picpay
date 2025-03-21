package com.fabricioaquiles.desafiopicpay.infrastructure.repository;

import com.fabricioaquiles.desafiopicpay.domain.model.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletRepository extends JpaRepository<Wallet, Long> {
}
