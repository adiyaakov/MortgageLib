package com.ay.mortgage_server_app.requestsBody;

import com.mortgage.server.mortgage.enums.LoanType;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
public class Loan {
    private long mortgageId;
    @NotNull
    private LoanType loanType;
    @Max(360)
    @Min(36)
    private int monthsLength;
    @Max(100)
    @Min(0)
    private double percentage;
}
