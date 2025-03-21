package com.fabricioaquiles.desafiopicpay.infrastructure.client;

import com.fabricioaquiles.desafiopicpay.infrastructure.client.dto.AuthorizationResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(
        url = "${client.authorization-mock.url}",
        name = "authorization"
)
public interface AuthorizationClient {

    @GetMapping
    ResponseEntity<AuthorizationResponse> isAuthorized();
}
