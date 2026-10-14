package com.pain.monitoring.core.domain.model.menstruation;

import com.pain.monitoring.core.domain.model.*;
import lombok.Builder;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

import static com.pain.monitoring.core.domain.model.ErrorMessages.*;

public class Menstruation implements AggregateRoot<UUID> {

    private UUID id;
    private LocalDate startDate;
    private LocalDate endDate;
    private Boolean onGoing;
    private String notes;
    private String duration;

    @Builder(builderClassName = "BrandNewMenstruation", builderMethodName = "brandNew")
    private static Menstruation createBrandNew(LocalDate startDate, LocalDate endDate,
                                                   Boolean onGoing, String notes) {

        return new Menstruation(
                IdGenerator.generateTimeBasedUUID(),
                startDate,
                endDate,
                onGoing,
                notes,
                null);
    }

    @Builder(builderClassName = "ExistingMenstruation", builderMethodName = "existing")
    private Menstruation(UUID id, LocalDate startDate, LocalDate endDate,
                             Boolean onGoing, String notes, String duration) {

        this.setId(id);
        this.setOnGoing(onGoing);
        this.setStartDate(startDate);
        this.setEndDate(endDate);
        this.setNotes(notes);
        this.setDuration(duration == null ? DurationCalculator.calculateDuration(onGoing, startDate, endDate) : duration);
    }

    public void changeNotes(String notes) {
        this.setNotes(notes);
    }

    public void changeDates(LocalDate startDate, LocalDate endDate, Boolean onGoing) {
        this.setStartDate(startDate);
        this.setOnGoing(onGoing);
        this.setEndDate(endDate);
        this.setDuration(DurationCalculator.calculateDuration(this.onGoing, this.startDate, this.endDate));
    }

    public UUID id() {
        return id;
    }

    public LocalDate startDate() {
        return startDate;
    }

    public LocalDate endDate() {
        return endDate;
    }

    public Boolean onGoing() {
        return onGoing;
    }

    public String notes() {
        return notes;
    }

    public String duration() {
        return duration;
    }

    private void setId(UUID id) {
        Objects.requireNonNull(id);
        this.id = id;
    }

    private void setStartDate(LocalDate startDate) {
        Objects.requireNonNull(startDate);
        if (startDate.isAfter(LocalDate.now()))
            throw new DateAfterNowException();
        this.startDate = startDate;
    }

    private void setEndDate(LocalDate endDate) {
        if (endDate == null) {
            if (!this.onGoing)
                throw new MenstruationRequiresEndDateException(VALIDATION_ERROR_END_DATE_NECESSARY);
            this.endDate = null;
            return;
        }
        Objects.requireNonNull(this.startDate);

        if (endDate.isAfter(LocalDate.now()))
            throw new DateAfterNowException();
        if (this.onGoing)
            throw new OngoingEventCannotHaveEndDateException(VALIDATION_ERROR_END_DATE_WITH_ON_GOING);
        if (this.startDate.isAfter(endDate))
            throw new StartDateAfterEndDateException(VALIDATION_ERROR_END_DATE_BEFORE_START_DATE);

        this.endDate = endDate;
    }

    private void setOnGoing(Boolean onGoing) {
        Objects.requireNonNull(onGoing);
        this.onGoing = onGoing;
    }

    private void setNotes(String notes) {
        this.notes = notes;
    }

    private void setDuration(String duration) {
        this.duration = duration;
    }
}
