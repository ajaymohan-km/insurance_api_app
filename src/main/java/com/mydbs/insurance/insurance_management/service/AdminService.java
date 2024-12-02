package com.mydbs.insurance.insurance_management.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.mydbs.insurance.insurance_management.model.ApplicationStatus;
import com.mydbs.insurance.insurance_management.model.Policy;
import com.mydbs.insurance.insurance_management.model.PolicyApplication;
import com.mydbs.insurance.insurance_management.model.User;
import com.mydbs.insurance.insurance_management.repository.PolicyApplicationRepository;
import com.mydbs.insurance.insurance_management.repository.PolicyRepository;
import com.mydbs.insurance.insurance_management.repository.UserRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AdminService {
    private final UserRepository userRepository;
    private final PolicyRepository policyRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public List<Policy> getPendingPolicies() {
        return policyRepository.findAll().stream()
            .filter(policy -> policy.getStatus() == "PENDING")
            .collect(Collectors.toList());
    }

    public User approveServiceProvider(String id) {
        User provider = userRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Provider not found"));
        provider.setEnabled(true);
        return userRepository.save(provider);
    }

    public User rejectServiceProvider(String id) {
        User provider = userRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Provider not found"));
        provider.setEnabled(false);
        return userRepository.save(provider);
    }
        private final PolicyApplicationRepository policyApplicationRepository;

    public PolicyApplication approveApplication(String id) {
        PolicyApplication application = policyApplicationRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Application not found"));
                // Create new policy from approved application
        Policy policy = new Policy();
        policy.setCustomerId(application.getCustomerId());
        policy.setPlanId(application.getPlanId());
        policy.setServiceProviderId(application.getProviderId());
        policy.setStatus("ACTIVE");
        policy.setStartDate(LocalDateTime.now());
        policy.setEndDate(LocalDateTime.now().plusYears(1)); // Set policy duration
        policy.setCreatedAt(LocalDateTime.now());
        policyRepository.save(policy);

        // Update application status
        application.setStatus(ApplicationStatus.APPROVED);
        return policyApplicationRepository.save(application);
    }
    public PolicyApplication rejectApplication(String id) {
        PolicyApplication application = policyApplicationRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Application not found"));
        application.setStatus(ApplicationStatus.REJECTED);
        return policyApplicationRepository.save(application);
    }
}