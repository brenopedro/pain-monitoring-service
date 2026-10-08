package com.pain.monitoring.infrastructure.adapters.out.persistence.medicalcondition;

import com.pain.monitoring.core.domain.model.medicalcondition.MedicalCondition;
import com.pain.monitoring.core.domain.model.medicalcondition.MedicalConditions;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class MedicalConditionsPersistenceProvider implements MedicalConditions {

    private final MedicalConditionPersistenceEntityRepository repository;
    private final MedicalConditionPersistenceEntityAssembler assembler;
    private final MedicalConditionPersistenceEntityDisassembler disassembler;

    @Override
    public Optional<MedicalCondition> ofId(UUID id) {
        return repository.findById(id).map(disassembler::toDomainEntity);
    }

    @Override
    public boolean exists(UUID id) {
        return repository.existsById(id);
    }

    @Override
    public void add(MedicalCondition aggregateRoot) {
        UUID id = aggregateRoot.id();

        repository.findById(id)
                .ifPresentOrElse(
                        persistenceEntity -> update(aggregateRoot, persistenceEntity),
                        () -> insert(aggregateRoot)
                );
    }

    @Override
    public long count() {
        return repository.count();
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
