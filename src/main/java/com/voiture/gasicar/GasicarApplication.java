package com.voiture.gasicar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan("com.voiture.gasicar.Model")
@SpringBootApplication
public class GasicarApplication {

	public static void main(String[] args) {
		SpringApplication.run(GasicarApplication.class, args);
	}

}
