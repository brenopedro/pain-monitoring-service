package com.pain.monitoring.infrastructure.adapters.out.persistence.medicalcondition;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.domain.AbstractAggregateRoot;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@Document(collection = "medical-condition")
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
@NoArgsConstructor
public class MedicalConditionPersistenceEntity extends AbstractAggregateRoot<MedicalConditionPersistenceEntity> {

    @Id
    @EqualsAndHashCode.Include
    private UUID id;

    private String name;
    private LocalDate startDate;
    private LocalDate endDate;
    private Boolean onGoing;
    private String notes;
    private String duration;
}
