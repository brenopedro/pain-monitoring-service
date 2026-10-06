package com.pain.monitoring.core.ports.in;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MedicalConditionSummaryOutput {

    private UUID id;
    private String name;
    private LocalDate startDate;
    private Boolean onGoing;
    private String duration;
}
