package com.pain.monitoring.core.domain.model;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

public class DurationCalculator {

    public static String calculateDuration(Boolean onGoing, LocalDate startDate, LocalDate endDate) {
        if (Boolean.TRUE.equals(onGoing)) return "-";
        return formatDuration(startDate, endDate);
    }

    private static String formatDuration(LocalDate startDate, LocalDate endDate) {
        Objects.requireNonNull(startDate);
        Objects.requireNonNull(endDate);
        Period period = Period.between(startDate, endDate);

        StringBuilder duration = new StringBuilder();
        if (period.getYears() > 0) duration.append(period.getYears()).append('Y');
        if (period.getMonths() > 0) duration.append(period.getMonths()).append('M');
        if (period.getDays() > 0) duration.append(period.getDays()).append('D');

        return duration.toString();
    }
}
