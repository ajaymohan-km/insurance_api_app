package com.mydbs.insurance.insurance_management.model;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class ConsultationRequest {
    private String serviceProviderId;
    private String planId;
    private LocalDateTime scheduledTime;
    private String notes;
}