package com.pain.monitoring.infrastructure.adapters.out.persistence.medicalcondition;

import com.pain.monitoring.core.domain.model.medicalcondition.MedicalCondition;
import com.pain.monitoring.core.ports.out.ForHandlingMedicalConditions;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class ForHandlingMedicalConditionImpl implements ForHandlingMedicalConditions {

    private final MedicalConditionPersistenceEntityRepository repository;
    private final MedicalConditionPersistenceEntityAssembler assembler;
    private final MedicalConditionPersistenceEntityDisassembler disassembler;

    @Override
    public void add(MedicalCondition aggregateRoot) {
        UUID id = aggregateRoot.id();

        repository.findById(id)
                .ifPresentOrElse(
                        persistenceEntity -> update(aggregateRoot, persistenceEntity),
                        () -> insert(aggregateRoot)
                );
    }


    private void update (MedicalCondition aggregateRoot, MedicalConditionPersistenceEntity persistenceEntity) {
        persistenceEntity = assembler.merge(persistenceEntity, aggregateRoot);
        repository.save(persistenceEntity);
    }

    private void insert(MedicalCondition aggregateRoot) {
        MedicalConditionPersistenceEntity persistenceEntity = assembler.fromDomain(aggregateRoot);
        repository.save(persistenceEntity);
    }
}
