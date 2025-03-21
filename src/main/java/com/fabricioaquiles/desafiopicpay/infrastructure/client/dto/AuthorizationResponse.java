package com.fabricioaquiles.desafiopicpay.infrastructure.client.dto;

public record AuthorizationResponse(String status, AuthorizationData data) {
}
