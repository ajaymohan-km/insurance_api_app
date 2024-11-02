package com.mydbs.insurance.insurance_management.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.math.BigDecimal;

@Data
@Document(collection = "insurance_plans")
public class InsurancePlan {
    @Id
    private String id;
    private String name;
    private String description;
    private BigDecimal premium;
    private BigDecimal coverage;
    private String terms;
    private boolean active = true;
}
