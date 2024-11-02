package com.mydbs.insurance.insurance_management.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.mydbs.insurance.insurance_management.model.Policy;
import com.mydbs.insurance.insurance_management.model.User;
import com.mydbs.insurance.insurance_management.repository.PolicyRepository;
import com.mydbs.insurance.insurance_management.repository.UserRepository;

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
}