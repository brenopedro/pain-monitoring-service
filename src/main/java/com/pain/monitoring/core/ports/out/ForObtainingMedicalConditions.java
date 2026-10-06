package com.pain.monitoring.core.ports.out;

import com.pain.monitoring.core.ports.in.MedicalConditionOutput;

import java.util.UUID;

public interface ForObtainingMedicalConditions {
    MedicalConditionOutput findById(UUID id);
}
