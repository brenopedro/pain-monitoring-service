package com.pain.monitoring.core.ports.in.menstruation;

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
public class MenstruationOutput {

    private UUID id;
    private LocalDate startDate;
    private LocalDate endDate;
    private Boolean onGoing;
    private String notes;
    private String duration;
}
