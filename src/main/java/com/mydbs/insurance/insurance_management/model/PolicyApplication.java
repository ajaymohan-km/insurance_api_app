package com.mydbs.insurance.insurance_management.model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PolicyApplication {
    @Id
    private String id;
    private String customerId;
    private String planId;
    private String providerId;
    private String consultationId;
    private ApplicationStatus status;
    private LocalDateTime submissionDate;
    private Map<String, Object> applicationData;
    private List<String> documents;
}
