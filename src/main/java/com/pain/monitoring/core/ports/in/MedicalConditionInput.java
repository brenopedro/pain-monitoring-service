package com.pain.monitoring.core.ports.in;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MedicalConditionInput {

    @NotBlank
    private String name;

    @NotNull
    private LocalDate startDate;
    private LocalDate endDate;

    @NotNull
    private Boolean onGoing;
    private String notes;
}
