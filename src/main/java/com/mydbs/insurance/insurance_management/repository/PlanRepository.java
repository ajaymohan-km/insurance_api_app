package com.mydbs.insurance.insurance_management.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import com.mydbs.insurance.insurance_management.model.Plan;

@Repository
public interface PlanRepository extends MongoRepository<Plan, String> {
    List<Plan> findByCategory(String category);
    List<Plan> findByActiveTrue();
    Optional<Plan> findByIdAndActiveTrue(String id);
}
