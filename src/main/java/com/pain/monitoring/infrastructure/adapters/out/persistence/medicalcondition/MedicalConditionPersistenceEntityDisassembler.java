package com.pain.monitoring.infrastructure.adapters.out.persistence.medicalcondition;

import com.pain.monitoring.core.domain.model.medicalcondition.MedicalCondition;
import org.springframework.stereotype.Component;

@Component
public class MedicalConditionPersistenceEntityDisassembler {

    public MedicalCondition toDomainEntity(MedicalConditionPersistenceEntity persistenceEntity) {
        return MedicalCondition.existing()
                .id(persistenceEntity.getId())
                .name(persistenceEntity.getName())
                .onGoing(persistenceEntity.getOnGoing())
                .startDate(persistenceEntity.getStartDate())
                .endDate(persistenceEntity.getEndDate())
                .notes(persistenceEntity.getNotes())
                .duration(persistenceEntity.getDuration())
                .build();
    }
}
