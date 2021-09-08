package com.mortgage.server.mortgage;

import com.mortgage.server.mortgage.enums.LoanType;
import com.mortgage.server.mortgage.loans.fixeRate.FixedRate;
import com.mortgage.server.mortgage.models.Mortgage;

public class MortgageApplication {

	public static void main(String[] args) {
		Mortgage mortgage = new Mortgage(1000000, 200000, 5000);
		mortgage.insertOrUpdateLoan(LoanType.FIX_RATE, new FixedRate());

		mortgage.getLoansMix().get(LoanType.FIX_RATE).getFirstPayment();

		mortgage.getLoansMix().get(LoanType.FIX_RATE).setPrinciple(230000);
		mortgage.getLoansMix().get(LoanType.FIX_RATE).setRate(2.3);
		mortgage.getLoansMix().get(LoanType.FIX_RATE).setYearsLength(20);

		mortgage.getLoansMix().get(LoanType.FIX_RATE).getFirstPayment();


	}

}
