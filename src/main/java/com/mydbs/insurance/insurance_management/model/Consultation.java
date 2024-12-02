package com.mydbs.insurance.insurance_management.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;

@Data
@Document(collection = "consultations")
public class Consultation {
    @Id
    private String id;
    private String customerId;
    private String serviceProviderId;
    private String planId;
    private LocalDateTime scheduledTime;
    private String status;
    private String notes;
    private LocalDateTime createdAt;
}