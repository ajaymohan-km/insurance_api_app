package com.mydbs.insurance.insurance_management.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.mydbs.insurance.insurance_management.model.Claim;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ClaimRepository extends MongoRepository<Claim, String> {
    List<Claim> findByCustomerId(String customerId);
    List<Claim> findByServiceProviderId(String serviceProviderId);
    List<Claim> findByStatus(String status);
    List<Claim> findByCreatedAtBetween(LocalDateTime start, LocalDateTime end);
    long countByStatus(String status);
    List<Claim> findByPolicyId(String policyId);
    List<Claim> findTop10ByOrderByCreatedAtDesc();
}