package com.mydbs.insurance.insurance_management.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.mydbs.insurance.insurance_management.model.Payment;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface PaymentRepository extends MongoRepository<Payment, String> {
    // Find payments by customer
    List<Payment> findByCustomerId(String customerId);
    
    // Find payments by status
    List<Payment> findByStatus(String status);
    
    // Find payments by policy
    List<Payment> findByPolicyId(String policyId);
    
    // Find recent payments
    List<Payment> findTop10ByOrderByCreatedAtDesc();
    
    // Find payments within a date range
    List<Payment> findByCreatedAtBetween(LocalDateTime startDate, LocalDateTime endDate);
    
    // Count payments by status
    long countByStatus(String status);
    
    // Find payments by method
    List<Payment> findByPaymentMethod(String paymentMethod);
    
    // Find payments above amount
    List<Payment> findByAmountGreaterThan(BigDecimal amount);
    
    // Find payments by customer and status
    List<Payment> findByCustomerIdAndStatus(String customerId, String status);
}