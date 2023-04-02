package com.example.pons;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example.pons.controller","com.example.pons.model","com.example.pons.repository","com.example.pons.service","com.example.pons.exception","com.example.pons.config"})
public class EventManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(EventManagementApplication.class, args);
	}

}
