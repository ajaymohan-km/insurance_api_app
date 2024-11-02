package com.mydbs.insurance.insurance_management.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Map;

@Data
@Document(collection = "payments")
public class Payment {
    @Id
    private String id;
    private String policyId;
    private String customerId;
    private BigDecimal amount;
    private String status;
    private String paymentMethod;
    private String transactionId;
    private String currency = "USD";
    private String description;
    private Map<String, String> metadata;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}