package com.fabricioaquiles.desafiopicpay.domain.service;

import com.fabricioaquiles.desafiopicpay.infrastructure.client.AuthorizationClient;
import com.fabricioaquiles.desafiopicpay.infrastructure.exceptions.UnauthorizedTransactionException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class AuthorizationService {

    private final AuthorizationClient authorizationClient;

    public boolean isAuthorized() {
        try {
            var response = authorizationClient.isAuthorized();

            return Objects.equals(response.getBody().data().authorization(), "true");
        } catch (Exception e) {
            throw new UnauthorizedTransactionException("Unauthorized transaction");
        }
    }
}
