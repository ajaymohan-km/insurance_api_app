package com.mydbs.insurance.insurance_management.repository;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.mydbs.insurance.insurance_management.model.ApplicationStatus;
import com.mydbs.insurance.insurance_management.model.PolicyApplication;

@Repository
public interface PolicyApplicationRepository extends MongoRepository<PolicyApplication, String> {
    List<PolicyApplication> findByCustomerId(String customerId);
    List<PolicyApplication> findByStatus(ApplicationStatus status);
}
