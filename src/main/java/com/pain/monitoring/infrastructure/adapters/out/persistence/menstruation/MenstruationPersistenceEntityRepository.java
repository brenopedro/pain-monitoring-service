package com.pain.monitoring.infrastructure.adapters.out.persistence.menstruation;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface MenstruationPersistenceEntityRepository extends
        MongoRepository<MenstruationPersistenceEntity, UUID> {
}
