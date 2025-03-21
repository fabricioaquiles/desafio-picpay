package com.fabricioaquiles.desafiopicpay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class DesafiopicpayApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesafiopicpayApplication.class, args);
	}

}
