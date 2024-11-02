package com.mydbs.insurance.insurance_management.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.mydbs.insurance.insurance_management.model.Claim;
import com.mydbs.insurance.insurance_management.model.ClaimRequest;
import com.mydbs.insurance.insurance_management.service.ClaimService;

import java.util.List;

@RestController
@RequestMapping("/api/claims")
@RequiredArgsConstructor
public class ClaimController {
    private final ClaimService claimService;

    @PostMapping
    public ResponseEntity<Claim> submitClaim(@RequestBody ClaimRequest request) {
        return ResponseEntity.ok(claimService.submitClaim(request));
    }

    @GetMapping
    public ResponseEntity<List<Claim>> getUserClaims() {
        return ResponseEntity.ok(claimService.getUserClaims());
    }

    @PutMapping("/{id}/approve")
    public ResponseEntity<Claim> approveClaim(@PathVariable String id) {
        return ResponseEntity.ok(claimService.approveClaim(id));
    }

    @PutMapping("/{id}/reject")
    public ResponseEntity<Claim> rejectClaim(@PathVariable String id) {
        return ResponseEntity.ok(claimService.rejectClaim(id));
    }
}