package com.mydbs.insurance.insurance_management.model;

import lombok.Data;
import java.math.BigDecimal;
import java.time.YearMonth;
import java.util.List;
import java.util.Map;

@Data
public class RevenueProjection {
    private YearMonth projectionPeriod;
    private BigDecimal projectedRevenue;
    private BigDecimal bestCaseRevenue;
    private BigDecimal worstCaseRevenue;
    private double confidenceScore;
    private Map<String, BigDecimal> revenueByProduct;
    private double growthRate;
    private List<String> contributingFactors;
    private Map<String, Double> seasonalityFactors;
}