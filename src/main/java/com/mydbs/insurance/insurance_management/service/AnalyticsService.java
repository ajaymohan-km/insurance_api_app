package com.mydbs.insurance.insurance_management.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.mydbs.insurance.insurance_management.model.ClaimsMetrics;
import com.mydbs.insurance.insurance_management.model.DashboardStats;
import com.mydbs.insurance.insurance_management.model.MonthlyTrend;
import com.mydbs.insurance.insurance_management.model.Payment;
import com.mydbs.insurance.insurance_management.model.RevenueAnalytics;
import com.mydbs.insurance.insurance_management.model.TransactionSummary;
import com.mydbs.insurance.insurance_management.model.UserGrowthStats;
import com.mydbs.insurance.insurance_management.repository.ClaimRepository;
import com.mydbs.insurance.insurance_management.repository.PaymentRepository;
import com.mydbs.insurance.insurance_management.repository.PolicyRepository;
import com.mydbs.insurance.insurance_management.repository.UserRepository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AnalyticsService {
    private final PolicyRepository policyRepository;
    private final ClaimRepository claimRepository;
    private final PaymentRepository paymentRepository;
    private final UserRepository userRepository;

    public DashboardStats getDashboardStats() {
        DashboardStats stats = new DashboardStats();
        
       // stats.setTotalActivePolicies(countActivePolicies());
        stats.setTotalPendingClaims(countPendingClaims());
        stats.setTotalRevenue(calculateTotalRevenue());
      //  stats.setUserGrowth(calculateUserGrowth());
      //  stats.setRecentTransactions(getRecentTransactions());
        
        return stats;
    }

    // public ClaimsMetrics getClaimsMetrics() {
    //     ClaimsMetrics metrics = new ClaimsMetrics();
        
    //     metrics.setApprovalRate(calculateClaimApprovalRate());
    //     metrics.setAverageProcessingTime(calculateAverageProcessingTime());
    //     metrics.setClaimsByType(getClaimsByType());
    //     metrics.setMonthlyTrends(getMonthlyClaimTrends());
        
    //     return metrics;
    // }

    // public RevenueAnalytics getRevenueAnalytics(String timeFrame) {
    //     RevenueAnalytics analytics = new RevenueAnalytics();
        
    //     analytics.setTotalRevenue(calculateRevenueByTimeFrame(timeFrame));
    //     analytics.setRevenueByProduct(getRevenueByProduct(timeFrame));
    //     analytics.setGrowthRate(calculateGrowthRate(timeFrame));
    //     analytics.setProjections(generateRevenueProjections());
        
    //     return analytics;
    // }

    // private long countActivePolicies() {
    //     return policyRepository.countByStatus("ACTIVE");
    // }

    private long countPendingClaims() {
        return claimRepository.countByStatus("SUBMITTED");
    }

    private BigDecimal calculateTotalRevenue() {
        return paymentRepository.findByStatus("COMPLETED")
                .stream()
                .map(Payment::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }


    // private List<TransactionSummary> getRecentTransactions() {
    //     return paymentRepository.findTop10ByOrderByCreatedAtDesc()
    //             .stream()
    //             .map(this::mapToTransactionSummary)
    //             .toList();
    // }

    // private double calculateClaimApprovalRate() {
    //     long approvedClaims = claimRepository.countByStatus(ClaimStatus.APPROVED);
    //     long totalClaims = claimRepository.count();
    //     return totalClaims > 0 ? (double) approvedClaims / totalClaims : 0;
    // }

    // private Map<String, Long> getClaimsByType() {
    //     return claimRepository.findAll()
    //             .stream()
    //             .collect(groupingBy(claim -> claim.getType().toString(), counting()));
    // }

    // private List<MonthlyTrend> getMonthlyClaimTrends() {
    //     // Implementation for monthly trends calculation
    //     return calculateMonthlyTrends();
    // }
}