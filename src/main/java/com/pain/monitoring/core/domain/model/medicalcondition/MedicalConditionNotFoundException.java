package com.pain.monitoring.core.domain.model.medicalcondition;

import com.pain.monitoring.core.domain.model.DomainEntityNotFoundException;

import java.util.UUID;

public class MedicalConditionNotFoundException extends DomainEntityNotFoundException {

    public MedicalConditionNotFoundException() {
    }

    public MedicalConditionNotFoundException(UUID id) {
        super(String.format("Medical condition with id %s does not exist", id));
    }
}
