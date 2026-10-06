package com.pain.monitoring.core.domain.model;

public class CannotHaveEndDateIfOnGoingException extends DomainException {

    public CannotHaveEndDateIfOnGoingException() {
    }

    public CannotHaveEndDateIfOnGoingException(String message) {
        super(message);
    }

    public CannotHaveEndDateIfOnGoingException(String message, Throwable cause) {
        super(message, cause);
    }
}
