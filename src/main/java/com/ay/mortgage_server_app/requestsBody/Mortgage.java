package com.ay.mortgage_server_app.requestsBody;

import lombok.Data;
import lombok.Getter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;

@Data
public class Mortgage {
    @NotNull
    private String title;
    @NotEmpty(message = "List cannot be empty.")
    private ArrayList<Loan> loansMix;

    public String getTitle() {
        return title;
    }

    public ArrayList<Loan> getLoansMix() {
        return loansMix;
    }
}
