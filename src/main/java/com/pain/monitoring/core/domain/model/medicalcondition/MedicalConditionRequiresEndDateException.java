package com.pain.monitoring.core.domain.model.medicalcondition;

import com.pain.monitoring.core.domain.model.DomainException;

public class MedicalConditionRequiresEndDateException extends DomainException {
    public MedicalConditionRequiresEndDateException() {
    }

    public MedicalConditionRequiresEndDateException(String message) {
        super(message);
    }

    public MedicalConditionRequiresEndDateException(String message, Throwable cause) {
        super(message, cause);
    }
}
