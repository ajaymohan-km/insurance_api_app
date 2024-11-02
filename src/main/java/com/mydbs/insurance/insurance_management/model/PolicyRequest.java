package com.mydbs.insurance.insurance_management.model;

import lombok.Data;

@Data
public class PolicyRequest {
    private String planId;
    private String serviceProviderId;
}