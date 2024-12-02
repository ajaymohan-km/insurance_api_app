package com.mydbs.insurance.insurance_management.model;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class ClaimAuthorizationRequest {
    private String diagnosis;
    private String treatmentPlan;
    private BigDecimal authorizedAmount;
    private String notes;
}
