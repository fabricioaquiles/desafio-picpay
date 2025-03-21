package com.fabricioaquiles.desafiopicpay.infrastructure.repository;

import com.fabricioaquiles.desafiopicpay.domain.model.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionsRepository extends JpaRepository<Transactions, Long> {
}
