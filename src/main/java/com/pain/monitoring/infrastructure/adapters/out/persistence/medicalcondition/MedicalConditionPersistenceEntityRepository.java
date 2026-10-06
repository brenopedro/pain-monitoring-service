package com.pain.monitoring.infrastructure.adapters.out.persistence.medicalcondition;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface MedicalConditionPersistenceEntityRepository extends
        MongoRepository<MedicalConditionPersistenceEntity, UUID> {
}
