package com.pain.monitoring.core.domain.model.health;

import com.pain.monitoring.core.domain.model.medicalcondition.MedicalCondition;
import lombok.*;
import org.springframework.data.annotation.*;
import org.springframework.data.domain.AbstractAggregateRoot;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Getter
@Document(collection = "health")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Health extends AbstractAggregateRoot<Health> {

    @Id
    @EqualsAndHashCode.Include
    private UUID id;

    private UUID userId;

    private String gender;
    private LocalDate dayOfBirth;

    private List<Menstruation> menstruations = new ArrayList<>();
    private List<Treatment> treatments;
    private List<MedicalCondition> medicalConditions;
    private List<Other> others;

    @Version
    private Long version;

    @CreatedDate
    private OffsetDateTime addedAt;

    @LastModifiedDate
    private OffsetDateTime updatedAt;

    @CreatedBy
    private UUID createdByUserId;

    @LastModifiedBy
    private UUID lastModifiedByUserId;


    @Builder
    public Health(String gender, LocalDate dayOfBirth) {

    }

    public void addMenstruationData(Menstruation menstruation) {
        Objects.requireNonNull(menstruation);
        this.menstruations.add(menstruation);
    }


    private void setId(UUID id) {
        this.id = id;
    }

    private void setUserId(UUID userId) {
        this.userId = userId;
    }

    private void setGender(String gender) {
        this.gender = gender;
    }

    private void setDayOfBirth(LocalDate dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    private void setMenstruations(List<Menstruation> menstruations) {
        this.menstruations = menstruations;
    }

    private void setTreatments(List<Treatment> treatments) {
        this.treatments = treatments;
    }

    private void setMedicalConditions(List<MedicalCondition> medicalConditions) {
        this.medicalConditions = medicalConditions;
    }

    private void setOthers(List<Other> others) {
        this.others = others;
    }

}