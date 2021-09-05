package com.mortgage.server.mortgage;

import com.mortgage.server.mortgage.loans.fixeRate.FixedRateFiveYearsChangesLoan;
import com.mortgage.server.mortgage.models.Mortgage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MortgageApplication {

	public static void main(String[] args) {
		SpringApplication.run(MortgageApplication.class, args);

		Mortgage mortgage = new Mortgage(1000000, 200000, 5000);
		mortgage.getDealBalance();
	}

}
