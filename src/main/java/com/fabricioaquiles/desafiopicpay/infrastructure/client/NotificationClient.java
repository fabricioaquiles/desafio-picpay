package com.fabricioaquiles.desafiopicpay.infrastructure.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(
        url = "${client.notification-mock.url}",
        name = "notification"
)
public interface NotificationClient {

    @PostMapping
    ResponseEntity<Void> sendNotification();
}
