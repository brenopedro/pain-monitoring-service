package com.pain.monitoring.core.domain.model;

public class OngoingEventCannotHaveEndDateException extends DomainException {

    public OngoingEventCannotHaveEndDateException() {
    }

    public OngoingEventCannotHaveEndDateException(String message) {
        super(message);
    }

    public OngoingEventCannotHaveEndDateException(String message, Throwable cause) {
        super(message, cause);
    }
}
