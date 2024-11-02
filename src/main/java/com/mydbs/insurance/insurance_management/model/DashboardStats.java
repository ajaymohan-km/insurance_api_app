package com.mydbs.insurance.insurance_management.model;

import lombok.Data;
import java.math.BigDecimal;
import java.util.List;

@Data
public class DashboardStats {
    private long totalActivePolicies;
    private long totalPendingClaims;
    private BigDecimal totalRevenue;
    private UserGrowthStats userGrowth;
    private List<TransactionSummary> recentTransactions;
}