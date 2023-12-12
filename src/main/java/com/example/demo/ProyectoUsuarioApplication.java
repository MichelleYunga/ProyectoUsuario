package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.models.annotations.OpenAPI30;
@OpenAPI30
@SpringBootApplication
public class ProyectoUsuarioApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProyectoUsuarioApplication.class, args);
	}

}
