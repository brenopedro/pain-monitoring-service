package com.pain.monitoring.core.domain.model.menstruation;

import com.pain.monitoring.core.domain.model.DomainException;

public class MenstruationRequiresEndDateException extends DomainException {
    public MenstruationRequiresEndDateException() {
    }

    public MenstruationRequiresEndDateException(String message) {
        super(message);
    }

    public MenstruationRequiresEndDateException(String message, Throwable cause) {
        super(message, cause);
    }
}
