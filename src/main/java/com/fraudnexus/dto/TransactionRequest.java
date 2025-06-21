package com.fraudnexus.dto;


import java.math.BigDecimal;

public class TransactionRequest{

    private Long customerId;
    private BigDecimal amount;
    private  String description;

    public TransactionRequest() {
    }
    public TransactionRequest(Long customerId, BigDecimal amount, String description) {
    this.customerId = customerId;
    this.amount = amount;
    this.description = description;
    }
    public Long getCustomerId() { return this.customerId; }
    public void setCustomerId(Long customerId) { this.customerId = customerId; }

    public BigDecimal getAmount() { return amount; }
    public void setAmount(BigDecimal amount) { this.amount = amount; }

    public String getDescription() { return this.description; }
    public void setDescription(String description) { this.description = description; }
}



