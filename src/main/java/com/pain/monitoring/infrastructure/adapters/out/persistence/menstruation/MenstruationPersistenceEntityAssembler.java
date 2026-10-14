package com.pain.monitoring.infrastructure.adapters.out.persistence.menstruation;

import com.pain.monitoring.core.domain.model.menstruation.Menstruation;
import org.springframework.stereotype.Component;

@Component
public class MenstruationPersistenceEntityAssembler {

    public MenstruationPersistenceEntity fromDomain(Menstruation menstruation) {
        return merge(new MenstruationPersistenceEntity(), menstruation);
    }

    public MenstruationPersistenceEntity merge(MenstruationPersistenceEntity entity, Menstruation domain) {
        entity.setId(domain.id());
        entity.setStartDate(domain.startDate());
        entity.setEndDate(domain.endDate());
        entity.setOnGoing(domain.onGoing());
        entity.setNotes(domain.notes());
        entity.setDuration(domain.duration());
        return entity;
    }
}
