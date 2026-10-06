package com.pain.monitoring.core.domain.model;

import java.util.Objects;

public class FieldValidator {

    private FieldValidator() {
    }

    public static void requiresNonBlank(String value) {
        requiresNonBlank(value, "");
    }

    public static void requiresNonBlank(String value, String errorMessage) {
        Objects.requireNonNull(value, errorMessage);
        if (value.isBlank()) {
            throw new IllegalArgumentException(errorMessage);
        }
    }
}
