package com.mydbs.insurance.insurance_management.repository;


import org.springframework.data.mongodb.repository.MongoRepository;

import com.mydbs.insurance.insurance_management.model.Consultation;

import java.util.List;

public interface ConsultationRepository extends MongoRepository<Consultation, String> {
    List<Consultation> findByCustomerId(String customerId);
    List<Consultation> findByServiceProviderId(String serviceProviderId);
}