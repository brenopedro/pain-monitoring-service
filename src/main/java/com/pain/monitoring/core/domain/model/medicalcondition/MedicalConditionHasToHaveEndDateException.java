package com.pain.monitoring.core.domain.model.medicalcondition;

import com.pain.monitoring.core.domain.model.DomainException;

public class MedicalConditionHasToHaveEndDateException extends DomainException {
    public MedicalConditionHasToHaveEndDateException() {
    }

    public MedicalConditionHasToHaveEndDateException(String message) {
        super(message);
    }

    public MedicalConditionHasToHaveEndDateException(String message, Throwable cause) {
        super(message, cause);
    }
}
