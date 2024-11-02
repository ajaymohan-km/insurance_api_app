package com.mydbs.insurance.insurance_management.repository;

import com.mydbs.insurance.insurance_management.model.Policy;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface PolicyRepository extends MongoRepository<Policy, String> {
    List<Policy> findByCustomerId(String customerId);
    List<Policy> findByServiceProviderId(String serviceProviderId);
}