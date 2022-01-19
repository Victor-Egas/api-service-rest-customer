package com.cuenta.bancaria;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@EnableEurekaClient
@SpringBootApplication
public class ApiServiceRestCuentaCorrienteApplication{

	public static void main(String[] args) {
		SpringApplication.run(ApiServiceRestCuentaCorrienteApplication.class, args);
	}

	
}
