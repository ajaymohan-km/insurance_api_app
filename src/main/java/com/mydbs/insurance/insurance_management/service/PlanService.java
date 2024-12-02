package com.mydbs.insurance.insurance_management.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.mydbs.insurance.insurance_management.model.Plan;
import com.mydbs.insurance.insurance_management.repository.PlanRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PlanService {
    private final PlanRepository planRepository;

    public Plan createPlan(Plan plan) {
        plan.setCreatedAt(LocalDateTime.now());
        plan.setUpdatedAt(LocalDateTime.now());
        return planRepository.save(plan);
    }

    public List<Plan> getAllActivePlans() {
        return planRepository.findByActiveTrue();
    }

    public List<Plan> getPlansByCategory(String category) {
        return planRepository.findByCategory(category);
    }

    public Plan getPlanById(String id) {
        return planRepository.findByIdAndActiveTrue(id)
            .orElseThrow(() -> new RuntimeException("Plan not found"));
    }
}
