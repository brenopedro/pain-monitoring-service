package com.pain.monitoring.infrastructure.adapters.out.persistence.medicalcondition;

import com.pain.monitoring.core.domain.model.medicalcondition.MedicalCondition;
import org.springframework.stereotype.Component;

@Component
public class MedicalConditionPersistenceEntityAssembler {

    public MedicalConditionPersistenceEntity fromDomain(MedicalCondition medicalCondition) {
        return merge(new MedicalConditionPersistenceEntity(), medicalCondition);
    }

    public MedicalConditionPersistenceEntity merge(MedicalConditionPersistenceEntity entity, MedicalCondition domain) {
        entity.setId(domain.id());
        entity.setName(domain.name());
        entity.setStartDate(domain.startDate());
        entity.setEndDate(domain.endDate());
        entity.setOnGoing(domain.onGoing());
        entity.setNotes(domain.notes());
        entity.setDuration(domain.duration());
        return entity;
    }
}
