package com.pain.monitoring.core.domain.model;

import static com.pain.monitoring.core.domain.model.ErrorMessages.VALIDATION_ERROR_DATE_CANNOT_BE_AFTER_NOW;

public class DateAfterNowException extends DomainException {

    public DateAfterNowException() {
        super(VALIDATION_ERROR_DATE_CANNOT_BE_AFTER_NOW);
    }
}
