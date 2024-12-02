package com.mydbs.insurance.insurance_management.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.mydbs.insurance.insurance_management.model.ApplicationStatus;
import com.mydbs.insurance.insurance_management.model.Consultation;
import com.mydbs.insurance.insurance_management.model.Policy;
import com.mydbs.insurance.insurance_management.model.PolicyApplication;
import com.mydbs.insurance.insurance_management.repository.ConsultationRepository;
import com.mydbs.insurance.insurance_management.repository.PolicyApplicationRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PolicyApplicationService {
    private final PolicyApplicationRepository policyApplicationRepository;
    private final UserService userService;
    private final PolicyService policyService;
    private final ConsultationRepository consultationRepository;

    public PolicyApplication submitApplication(PolicyApplication application) {
        application.setCustomerId(userService.getCurrentUserId());
        application.setSubmissionDate(LocalDateTime.now());
        application.setStatus(ApplicationStatus.SUBMITTED);
                // Update consultation status
        if (application.getConsultationId() != null) {
            Consultation consultation = consultationRepository.findById(application.getConsultationId())
                .orElseThrow(() -> new RuntimeException("Consultation not found"));
            consultation.setStatus("APPLIED");
            consultationRepository.save(consultation);
        }
        
        return policyApplicationRepository.save(application);
    }

    public List<PolicyApplication> getCustomerApplications() {
        return policyApplicationRepository.findByCustomerId(userService.getCurrentUserId());
    }

    public PolicyApplication getApplicationById(String id) {
        return policyApplicationRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Application not found"));
    }
    public List<PolicyApplication> getSubmittedApplications() {
        return policyApplicationRepository.findByStatus(ApplicationStatus.SUBMITTED);
    }
    

}
