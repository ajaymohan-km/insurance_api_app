package com.mydbs.insurance.insurance_management.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.mydbs.insurance.insurance_management.model.Claim;
import com.mydbs.insurance.insurance_management.model.ClaimRequest;
import com.mydbs.insurance.insurance_management.repository.ClaimRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClaimService {
    private final ClaimRepository claimRepository;
    private final UserService userService;

    public Claim submitClaim(ClaimRequest request) {
        Claim claim = new Claim();
        claim.setCustomerId(userService.getCurrentUserId());
        claim.setPolicyId(request.getPolicyId());
        claim.setAmount(request.getAmount());
        claim.setDescription(request.getDescription());
        claim.setStatus("SUBMITTED");
        return claimRepository.save(claim);
    }

    public List<Claim> getUserClaims() {
        String userId = userService.getCurrentUserId();
        return claimRepository.findByCustomerId(userId);
    }

    public Claim approveClaim(String id) {
        Claim claim = claimRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Claim not found"));
        claim.setStatus("APPROVED");
        return claimRepository.save(claim);
    }

    public Claim rejectClaim(String id) {
        Claim claim = claimRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Claim not found"));
        claim.setStatus("REJECTED");
        return claimRepository.save(claim);
    }
}