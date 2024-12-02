package com.mydbs.insurance.insurance_management.controller;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mydbs.insurance.insurance_management.model.PolicyApplication;
import com.mydbs.insurance.insurance_management.service.PolicyApplicationService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/applications")
@RequiredArgsConstructor
public class PolicyApplicationController {
    private final PolicyApplicationService applicationService;

    @PostMapping
    public ResponseEntity<PolicyApplication> submitApplication(@Valid @RequestBody PolicyApplication application) {
        return ResponseEntity.ok(applicationService.submitApplication(application));
    }

    @GetMapping
    public ResponseEntity<List<PolicyApplication>> getCustomerApplications() {
        return ResponseEntity.ok(applicationService.getCustomerApplications());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PolicyApplication> getApplicationById(@PathVariable String id) {
        return ResponseEntity.ok(applicationService.getApplicationById(id));
    }
    
    @GetMapping("/submitted")
    public ResponseEntity<List<PolicyApplication>> getSubmittedApplications() {
        return ResponseEntity.ok(applicationService.getSubmittedApplications());
    }

}
