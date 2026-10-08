package com.pain.monitoring.core.domain.model;

public class ErrorMessages {

    public static final String VALIDATION_ERROR_END_DATE_WITH_ON_GOING = "Cannot have end date with on going true";
    public static final String VALIDATION_ERROR_END_DATE_BEFORE_START_DATE = "End date has to be after start date";
    public static final String VALIDATION_ERROR_END_DATE_NECESSARY = "End date is necessary if on going is false";
    public static final String VALIDATION_ERROR_DATE_CANNOT_BE_AFTER_NOW = "Dates cannot be set after today";

    public static final String VALIDATION_ERROR_MEDICAL_CONDITION_BLANK = "Name of medical condition cannot be blank";
}
