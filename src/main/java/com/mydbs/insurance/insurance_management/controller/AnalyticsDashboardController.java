package com.mydbs.insurance.insurance_management.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.mydbs.insurance.insurance_management.model.ClaimsMetrics;
import com.mydbs.insurance.insurance_management.model.DashboardStats;
import com.mydbs.insurance.insurance_management.model.RevenueAnalytics;
import com.mydbs.insurance.insurance_management.service.AnalyticsService;

@RestController
@RequestMapping("/api/analytics")
@RequiredArgsConstructor
public class AnalyticsDashboardController {
    private final AnalyticsService analyticsService;

    @GetMapping("/dashboard")
    public ResponseEntity<DashboardStats> getDashboardStats() {
        return ResponseEntity.ok(analyticsService.getDashboardStats());
    }

    // @GetMapping("/claims/metrics")
    // public ResponseEntity<ClaimsMetrics> getClaimsMetrics() {
    //     return ResponseEntity.ok(analyticsService.getClaimsMetrics());
    // }

    // @GetMapping("/revenue")
    // public ResponseEntity<RevenueAnalytics> getRevenueAnalytics(
    //         @RequestParam(required = false) String timeFrame) {
    //     return ResponseEntity.ok(analyticsService.getRevenueAnalytics(timeFrame));
    // }
}