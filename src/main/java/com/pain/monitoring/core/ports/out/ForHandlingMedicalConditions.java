package com.pain.monitoring.core.ports.out;

import com.pain.monitoring.core.domain.model.medicalcondition.MedicalCondition;

public interface ForHandlingMedicalConditions {
    void add(MedicalCondition medicalCondition);
}
