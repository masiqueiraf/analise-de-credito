package com.masiqueira.analisecredito;

import com.masiqueira.analisecredito.service.AnaliseCreditoService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AnalisecreditoApplication {

	private AnaliseCreditoService analiseCreditoService;

	public AnalisecreditoApplication(AnaliseCreditoService analiseCreditoService) {
		this.analiseCreditoService = analiseCreditoService;
	}

	public static void main(String[] args) {
		SpringApplication.run(AnalisecreditoApplication.class, args);
	}
}
