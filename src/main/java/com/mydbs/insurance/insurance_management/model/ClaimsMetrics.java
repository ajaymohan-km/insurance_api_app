package com.mydbs.insurance.insurance_management.model;

import lombok.Data;
import java.util.List;
import java.util.Map;

@Data
public class ClaimsMetrics {
    private double approvalRate;
    private double averageProcessingTime;
    private Map<String, Long> claimsByType;
    private List<MonthlyTrend> monthlyTrends;
}