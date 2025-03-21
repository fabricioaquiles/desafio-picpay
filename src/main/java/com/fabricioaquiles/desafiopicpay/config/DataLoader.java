package com.fabricioaquiles.desafiopicpay.config;

import com.fabricioaquiles.desafiopicpay.domain.model.User;
import com.fabricioaquiles.desafiopicpay.domain.model.Wallet;
import com.fabricioaquiles.desafiopicpay.domain.model.enums.UserType;
import com.fabricioaquiles.desafiopicpay.infrastructure.repository.UserRepository;
import com.fabricioaquiles.desafiopicpay.infrastructure.repository.WalletRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {

    private final UserRepository userRepository;
    private final WalletRepository walletRepository;

    @Override
    public void run(String... args) throws Exception {
        if(userRepository.count() > 0) return;

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        List<User> users = Arrays.asList(
                User.builder()
                    .fullName("Fabricio Aquiles")
                    .email("fab.aquiles123@gmail.com")
                    .cpfCnpj("111.111.111.11")
                    .password(encoder.encode("12345678"))
                    .userType(UserType.USER)
                .build(),
                User.builder()
                        .fullName("Joao Pedro")
                        .email("joao.pedro123@gmail.com")
                        .cpfCnpj("222.222.222.22")
                        .password(encoder.encode("123456"))
                        .userType(UserType.USER)
                .build(),
                User.builder()
                        .fullName("Catarina Sampaio")
                        .email("catarina.sampaio123@gmail.com")
                        .cpfCnpj("333.333.333.33")
                        .password(encoder.encode("1234"))
                        .userType(UserType.MERCHANT)
                .build()
        );

        List<Wallet> wallets = new ArrayList<>(users).stream().map(user -> Wallet.builder()
                .balance(new BigDecimal("5000.00"))
                .user(user)
                .build()).toList();


        userRepository.saveAll(users);
        walletRepository.saveAll(wallets);
    }
}
