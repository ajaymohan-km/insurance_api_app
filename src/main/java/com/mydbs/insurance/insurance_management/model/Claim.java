package com.mydbs.insurance.insurance_management.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Document(collection = "claims")
public class Claim {
    @Id
    private String id;
    private String policyId;
    private String consultationId;
    private String customerId;
    private String serviceProviderId;
    private BigDecimal amount;
    private String status;
    private String description;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
