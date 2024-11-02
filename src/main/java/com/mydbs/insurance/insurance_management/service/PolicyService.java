package com.mydbs.insurance.insurance_management.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.mydbs.insurance.insurance_management.model.Policy;
import com.mydbs.insurance.insurance_management.model.PolicyRequest;
import com.mydbs.insurance.insurance_management.repository.PolicyRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PolicyService {
    private final PolicyRepository policyRepository;
    private final UserService userService;

    public Policy createPolicy(PolicyRequest request) {
        Policy policy = new Policy();
        policy.setCustomerId(userService.getCurrentUserId());
        policy.setPlanId(request.getPlanId());
        policy.setServiceProviderId(request.getServiceProviderId());
        policy.setStatus("PENDING");
        return policyRepository.save(policy);
    }

    public List<Policy> getCurrentUserPolicies() {
        String userId = userService.getCurrentUserId();
        return policyRepository.findByCustomerId(userId);
    }

    public Policy getPolicyById(String id) {
        return policyRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Policy not found"));
    }
}