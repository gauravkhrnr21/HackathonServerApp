package com.tsys.febfive;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.batch.BatchAutoConfiguration;

@SpringBootApplication
@EnableAutoConfiguration(exclude={BatchAutoConfiguration.class})
public class FebFiveApplication {

	public static void main(String[] args) {
		SpringApplication.run(FebFiveApplication.class, args);
	}
	
}
