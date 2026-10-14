package com.pain.monitoring.infrastructure.adapters.out.persistence.menstruation;

import com.pain.monitoring.core.domain.model.menstruation.Menstruation;
import org.springframework.stereotype.Component;

@Component
public class MenstruationPersistenceEntityDisassembler {

    public Menstruation toDomainEntity(MenstruationPersistenceEntity persistenceEntity) {
        return Menstruation.existing()
                .id(persistenceEntity.getId())
                .onGoing(persistenceEntity.getOnGoing())
                .startDate(persistenceEntity.getStartDate())
                .endDate(persistenceEntity.getEndDate())
                .notes(persistenceEntity.getNotes())
                .duration(persistenceEntity.getDuration())
                .build();
    }
}
