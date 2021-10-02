package com.ay.mortgage_server_app;

import com.ay.mortgage_server_app.db.repositories.MortgageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MortgageServerAppApplication {
	@Autowired
	MortgageRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(MortgageServerAppApplication.class, args);
	}

}
