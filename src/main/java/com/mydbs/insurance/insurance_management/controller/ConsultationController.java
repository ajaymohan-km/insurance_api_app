package com.mydbs.insurance.insurance_management.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.mydbs.insurance.insurance_management.model.Consultation;
import com.mydbs.insurance.insurance_management.model.ConsultationRequest;
import com.mydbs.insurance.insurance_management.service.ConsultationService;

import java.util.List;

@RestController
@RequestMapping("/api/consultations")
@RequiredArgsConstructor
public class ConsultationController {
    private final ConsultationService consultationService;

    @PostMapping
    public ResponseEntity<Consultation> scheduleConsultation(@RequestBody ConsultationRequest request) {
        return ResponseEntity.ok(consultationService.scheduleConsultation(request));
    }

    @GetMapping
    public ResponseEntity<List<Consultation>> getUserConsultations() {
        return ResponseEntity.ok(consultationService.getUserConsultations());
    }

    @PutMapping("/{id}/complete")
    public ResponseEntity<Consultation> completeConsultation(@PathVariable String id) {
        return ResponseEntity.ok(consultationService.completeConsultation(id));
    }
    @GetMapping("/provider")
    public ResponseEntity<List<Consultation>> getProviderConsultations() {
        return ResponseEntity.ok(consultationService.getProviderConsultations());
    }

}