package com.fabricioaquiles.desafiopicpay.application.dto;

import java.math.BigDecimal;

public record CreateTransactionDto(BigDecimal value, Long payer, Long payee){
}
