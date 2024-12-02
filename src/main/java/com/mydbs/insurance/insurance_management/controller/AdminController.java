package com.mydbs.insurance.insurance_management.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.mydbs.insurance.insurance_management.model.Policy;
import com.mydbs.insurance.insurance_management.model.PolicyApplication;
import com.mydbs.insurance.insurance_management.model.User;
import com.mydbs.insurance.insurance_management.service.AdminService;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class AdminController {
    private final AdminService adminService;

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(adminService.getAllUsers());
    }

    @GetMapping("/policies/pending")
    public ResponseEntity<List<Policy>> getPendingPolicies() {
        return ResponseEntity.ok(adminService.getPendingPolicies());
    }

    @PutMapping("/providers/{id}/approve")
    public ResponseEntity<User> approveServiceProvider(@PathVariable String id) {
        return ResponseEntity.ok(adminService.approveServiceProvider(id));
    }

    @PutMapping("/providers/{id}/reject")
    public ResponseEntity<User> rejectServiceProvider(@PathVariable String id) {
        return ResponseEntity.ok(adminService.rejectServiceProvider(id));
    }

    @PutMapping("/applications/{id}/approve")
    public ResponseEntity<PolicyApplication> approveApplication(@PathVariable String id) {
        return ResponseEntity.ok(adminService.approveApplication(id));
    }
    @PutMapping("/applications/{id}/reject")
    public ResponseEntity<PolicyApplication> rejectApplication(@PathVariable String id) {
        return ResponseEntity.ok(adminService.rejectApplication(id));
    }
}