package com.mydbs.insurance.insurance_management.model;

import lombok.Data;

@Data
public class UserGrowthStats {
    private long newUsers;
    private long totalUsers;
    private double growthRate;
    private String period = "MONTHLY"; // Can be DAILY, WEEKLY, MONTHLY, YEARLY

    private long activeUsers;
    private double retentionRate;
    private double churnRate;
}