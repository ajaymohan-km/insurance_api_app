package com.mydbs.insurance.insurance_management.controller;


import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.mydbs.insurance.insurance_management.service.ClaimService;
import com.mydbs.insurance.insurance_management.service.PolicyApplicationService;
import com.mydbs.insurance.insurance_management.service.PolicyService;




@RestController
@RequestMapping("/api/customer")
@RequiredArgsConstructor
public class CustomerController {


    private final PolicyService policyService;
    private final ClaimService claimService;
    private final PolicyApplicationService applicationService;

    @GetMapping("/dashboard/summary")
    public ResponseEntity<Map<String, Object>> getDashboardSummary() {
        Map<String, Object> summary = new HashMap<>();
        summary.put("policies", policyService.getCurrentUserPolicies());
        summary.put("claims", claimService.getUserClaims());
        summary.put("applications", applicationService.getCustomerApplications());
        return ResponseEntity.ok(summary);
    }

    // private final AccountService accountService;

    // @GetMapping("/accounts")
    // public ResponseEntity<List<Account>> getAccounts() {
    //     return ResponseEntity.ok(accountService.getCurrentUserAccounts());
    // }

    // @PostMapping("/transfer")
    // public ResponseEntity<Transaction> transfer(@RequestBody TransferRequest request) {
    //     return ResponseEntity.ok(accountService.transfer(request));
    // }
}
