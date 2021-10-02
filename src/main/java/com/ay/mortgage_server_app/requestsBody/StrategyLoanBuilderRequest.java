package com.ay.mortgage_server_app.requestsBody;

import javax.validation.constraints.NotNull;

public class StrategyLoanBuilderRequest {
    @NotNull
    private Double requiredPrinciple ;
    @NotNull
    private Double refundCapability;
    @NotNull
    private Double assetWorth;
    @NotNull
    private Double equity;


    public StrategyLoanBuilderRequest(Double requiredPrinciple, Double refundCapability) {
        this.requiredPrinciple = requiredPrinciple;
        this.refundCapability = refundCapability;
    }

    public Double getEquity() {
        return equity;
    }

    public Double getRequiredPrinciple() {
        return requiredPrinciple;
    }

    public StrategyLoanBuilderRequest setRequiredPrinciple(Double requiredPrinciple) {
        this.requiredPrinciple = requiredPrinciple;
        return this;
    }

    public Double getAssetWorth() {
        return assetWorth;
    }

    public Double getRefundCapability() {
        return refundCapability;
    }

    public StrategyLoanBuilderRequest setRefundCapability(Double refundCapability) {
        this.refundCapability = refundCapability;
        return this;
    }
}
