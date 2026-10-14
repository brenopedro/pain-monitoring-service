package com.pain.monitoring.core.ports.in.medicalcondition;

import java.util.UUID;

public interface ForQueryingMedicalCondition {
    MedicalConditionOutput findById(UUID id);

    Boolean exists(UUID id);
}
