package com.fabricioaquiles.desafiopicpay.domain.service;

import com.fabricioaquiles.desafiopicpay.infrastructure.client.NotificationClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class NotificationService {

    private final NotificationClient notificationClient;

    public void sendNotification() {
        try {
            log.info("Sending notification for transaction");
            var response = notificationClient.sendNotification();

            if(response.getStatusCode().isError()) {
                log.error("Failed to send notification: {}", response.getBody());
            }

            log.info("Notification sent successfully for transaction");
        } catch (Exception e) {
            log.error("An error occurred while sending notification: {}", e.getMessage());
        }
    }
}
