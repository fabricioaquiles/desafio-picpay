package com.fabricioaquiles.desafiopicpay.infrastructure.repository;

import com.fabricioaquiles.desafiopicpay.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
