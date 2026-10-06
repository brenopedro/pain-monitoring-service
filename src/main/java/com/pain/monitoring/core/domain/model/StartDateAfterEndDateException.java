package com.pain.monitoring.core.domain.model;

public class StartDateAfterEndDateException extends DomainException {

    public StartDateAfterEndDateException() {
    }

    public StartDateAfterEndDateException(String message) {
        super(message);
    }

    public StartDateAfterEndDateException(String message, Throwable cause) {
        super(message, cause);
    }
}
