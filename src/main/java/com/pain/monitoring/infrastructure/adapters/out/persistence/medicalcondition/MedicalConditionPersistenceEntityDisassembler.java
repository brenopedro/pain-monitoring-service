package com.pain.monitoring.infrastructure.adapters.out.persistence.medicalcondition;

import com.pain.monitoring.core.domain.model.medicalcondition.MedicalCondition;
import org.springframework.stereotype.Component;

@Component
public class MedicalConditionPersistenceEntityDisassembler {

    public MedicalCondition toDomainEntity(MedicalConditionPersistenceEntity persistenceEntity) {
        return MedicalCondition.existing()
                .id(persistenceEntity.getId())
                .name(persistenceEntity.getName())
                .startDate(persistenceEntity.getStartDate())
                .endDate(persistenceEntity.getEndDate())
                .onGoing(persistenceEntity.getOnGoing())
                .notes(persistenceEntity.getNotes())
                .duration(persistenceEntity.getDuration())
                .build();
    }
}
