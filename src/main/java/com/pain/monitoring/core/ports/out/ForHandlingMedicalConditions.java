package com.pain.monitoring.core.ports.out;

import com.pain.monitoring.core.domain.model.medicalcondition.MedicalCondition;

import java.util.UUID;

public interface ForHandlingMedicalConditions {
    void add(MedicalCondition medicalCondition);

    void delete(UUID id);
}
