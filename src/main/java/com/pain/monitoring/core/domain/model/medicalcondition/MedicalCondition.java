package com.pain.monitoring.core.domain.model.medicalcondition;

import com.pain.monitoring.core.domain.model.*;
import lombok.Builder;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

import static com.pain.monitoring.core.domain.model.ErrorMessages.*;


public class MedicalCondition {

    private UUID id;
    private String name;
    private LocalDate startDate;
    private LocalDate endDate;
    private Boolean onGoing;
    private String notes;
    private String duration;

    @Builder(builderClassName = "BrandNewMedicalCondition", builderMethodName = "brandNew")
    private static MedicalCondition createBrandNew(String name, LocalDate startDate, LocalDate endDate,
                                     Boolean onGoing, String notes) {

        return new MedicalCondition(
                IdGenerator.generateTimeBasedUUID(),
                name,
                startDate,
                endDate,
                onGoing,
                notes,
                null);
    }

    @Builder(builderClassName = "ExistingMedicalCondition", builderMethodName = "existing")
    private MedicalCondition(UUID id, String name, LocalDate startDate, LocalDate endDate,
                             Boolean onGoing, String notes, String duration) {

        this.setId(id);
        this.setName(name);
        this.setOnGoing(onGoing);
        this.setStartDate(startDate);
        this.setEndDate(endDate);
        this.setNotes(notes);
        this.setDuration(duration == null ? DurationCalculator.calculateDuration(onGoing, startDate, endDate) : duration);
    }

    public UUID id() {
        return id;
    }

    public String name() {
        return name;
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

    private void setName(String name) {
        FieldValidator.requiresNonBlank(name, VALIDATION_ERROR_MEDICAL_CONDITION_BLANK);
        this.name = name;
    }

    private void setStartDate(LocalDate startDate) {
        Objects.requireNonNull(startDate);
        this.startDate = startDate;
    }

    private void setEndDate(LocalDate endDate) {
        Objects.requireNonNull(this.startDate);
        if (this.onGoing)
            throw new CannotHaveEndDateIfOnGoingException(VALIDATION_ERROR_END_DATE_WITH_ON_GOING);
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
