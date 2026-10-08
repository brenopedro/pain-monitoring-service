package com.pain.monitoring.core.ports.in;

import java.util.UUID;

public interface ForManagingMedicalCondition {

    UUID create(MedicalConditionInput input);
    void delete(UUID id);
    void update(UUID id, MedicalConditionInput input);
}
