package com.fabricioaquiles.desafiopicpay.web.request;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record CreateTransactionRequest(
        @DecimalMin(value = "0.01", message = "O valor deve ser maior que zero.") @NotNull(message = "O campo 'value' é obrigatório.") BigDecimal value,
        @NotNull(message = "O campo 'payer' é obrigatório.") Long payer,
        @NotNull(message = "O campo 'payee' é obrigatório.") Long payee
) {
}
