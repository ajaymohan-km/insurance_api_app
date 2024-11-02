package com.mydbs.insurance.insurance_management.model;

import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Map;

@Data
public class TransactionSummary {
    private String transactionId;
    private String userId;
    private String policyId;
    private BigDecimal amount;
    private String transactionType;
    private String status;
    private LocalDateTime transactionDate;
    private String paymentMethod;
    
    private String currency = "USD";
    private String description;
    private Map<String, String> metadata;
}