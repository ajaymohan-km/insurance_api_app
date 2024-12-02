package com.mydbs.insurance.insurance_management.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.mydbs.insurance.insurance_management.model.Plan;
import com.mydbs.insurance.insurance_management.service.PlanService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/plans")
@RequiredArgsConstructor
public class PlanController {
    private final PlanService planService;

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Plan> createPlan(@Valid @RequestBody Plan plan) {
        return ResponseEntity.ok(planService.createPlan(plan));
    }

    @GetMapping
    public ResponseEntity<List<Plan>> getAllPlans() {
        return ResponseEntity.ok(planService.getAllActivePlans());
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<Plan>> getPlansByCategory(@PathVariable String category) {
        return ResponseEntity.ok(planService.getPlansByCategory(category));
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Plan> getPlanById(@PathVariable String id) {
        return ResponseEntity.ok(planService.getPlanById(id));
    }
}
