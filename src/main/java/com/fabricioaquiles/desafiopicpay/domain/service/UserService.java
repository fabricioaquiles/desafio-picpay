package com.fabricioaquiles.desafiopicpay.domain.service;

import com.fabricioaquiles.desafiopicpay.domain.model.User;
import com.fabricioaquiles.desafiopicpay.infrastructure.exceptions.UserNotFoundException;
import com.fabricioaquiles.desafiopicpay.infrastructure.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User findUser(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() ->
                        new UserNotFoundException("User not found")
                );
    }
}
