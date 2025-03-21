package com.fabricioaquiles.desafiopicpay.web.controller;

import com.fabricioaquiles.desafiopicpay.web.request.CreateTransactionRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;

@Validated
public interface ITransactionController {

    @Operation(description = "Endpoint responsavel por realizar transações")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Transação realizada com sucesso"),
            @ApiResponse(responseCode = "422", description = "Transação inválida (usuario, valor negativo, etc.) "),
            @ApiResponse(responseCode = "404", description = "Usuario não encontrado"),
            @ApiResponse(responseCode = "400", description = "Erro ao processar a transação"),
            @ApiResponse(responseCode = "403", description = "Transação não autorizada"),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor")
    })
    ResponseEntity<Void> transfer(@Valid @RequestBody CreateTransactionRequest createTransactionRequest);
}
