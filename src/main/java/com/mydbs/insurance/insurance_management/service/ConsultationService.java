package com.mydbs.insurance.insurance_management.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.mydbs.insurance.insurance_management.model.Consultation;
import com.mydbs.insurance.insurance_management.model.ConsultationRequest;
import com.mydbs.insurance.insurance_management.repository.ConsultationRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ConsultationService {
    private final ConsultationRepository consultationRepository;
    private final UserService userService;

    public Consultation scheduleConsultation(ConsultationRequest request) {
        Consultation consultation = new Consultation();
        consultation.setCustomerId(userService.getCurrentUserId());
        consultation.setServiceProviderId(request.getServiceProviderId());
        consultation.setScheduledTime(request.getScheduledTime());
        consultation.setStatus("SCHEDULED");
        return consultationRepository.save(consultation);
    }

    public List<Consultation> getUserConsultations() {
        String userId = userService.getCurrentUserId();
        return consultationRepository.findByCustomerId(userId);
    }

    public Consultation completeConsultation(String id) {
        Consultation consultation = consultationRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Consultation not found"));
        consultation.setStatus("COMPLETED");
        return consultationRepository.save(consultation);
    }
}