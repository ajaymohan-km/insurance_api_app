package com.mydbs.insurance.insurance_management.model;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class ClaimRequest {
    private String policyId;
    private String consultationId;
    private BigDecimal amount;
    private String description;
}