package com.mydbs.insurance.insurance_management.controller;



import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.mydbs.insurance.insurance_management.model.Policy;
import com.mydbs.insurance.insurance_management.model.PolicyRequest;
import com.mydbs.insurance.insurance_management.service.PolicyService;

import java.util.List;

@RestController
@RequestMapping("/api/policies")
@RequiredArgsConstructor
public class PolicyController {
    private final PolicyService policyService;

    @PostMapping
    public ResponseEntity<Policy> createPolicy(@RequestBody PolicyRequest request) {
        return ResponseEntity.ok(policyService.createPolicy(request));
    }

    @GetMapping
    public ResponseEntity<List<Policy>> getCurrentUserPolicies() {
        return ResponseEntity.ok(policyService.getCurrentUserPolicies());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Policy> getPolicyById(@PathVariable String id) {
        return ResponseEntity.ok(policyService.getPolicyById(id));
    }
}