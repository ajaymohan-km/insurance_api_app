package com.mydbs.insurance.insurance_management.model;

import lombok.Data;
import java.math.BigDecimal;
import java.util.Map;
import java.util.List;

@Data
public class RevenueAnalytics {
    private BigDecimal totalRevenue;
    private Map<String, BigDecimal> revenueByProduct;
    private double growthRate;
    private List<RevenueProjection> projections;
}