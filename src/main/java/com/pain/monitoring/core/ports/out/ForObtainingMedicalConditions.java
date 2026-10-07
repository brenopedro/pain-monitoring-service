package com.pain.monitoring.core.ports.out;

import com.pain.monitoring.core.domain.model.medicalcondition.MedicalCondition;

import java.util.UUID;

public interface ForObtainingMedicalConditions {
    MedicalCondition findById(UUID id);

    Boolean exists(UUID id);
}
