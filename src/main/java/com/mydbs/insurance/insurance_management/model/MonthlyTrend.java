package com.mydbs.insurance.insurance_management.model;

import lombok.Data;
import java.math.BigDecimal;
import java.time.YearMonth;
import java.util.Map;

@Data
public class MonthlyTrend {
    private YearMonth month;
    private long totalClaims;
    private long approvedClaims;
    private long rejectedClaims;
    private BigDecimal totalClaimAmount;
    private double approvalRate;
    private double monthOverMonthGrowth;
    private Map<String, Long> claimsByCategory;
    private BigDecimal averageClaimAmount;
}