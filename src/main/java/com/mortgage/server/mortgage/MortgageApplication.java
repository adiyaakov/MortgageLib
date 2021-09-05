package com.mortgage.server.mortgage;

import com.mortgage.server.mortgage.loans.fixeRate.FixedRateFiveYearsChangesLoan;
import com.mortgage.server.mortgage.models.Mortgage;

public class MortgageApplication {

	public static void main(String[] args) {
		Mortgage mortgage = new Mortgage(1000000, 200000, 5000);
		mortgage.getDealBalance();
	}

}
