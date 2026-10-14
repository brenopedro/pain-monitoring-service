package com.pain.monitoring.infrastructure.adapters.out.persistence.menstruation;

import com.pain.monitoring.core.domain.model.menstruation.Menstruation;
import com.pain.monitoring.core.domain.model.menstruation.Menstruations;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class MenstruationPersistenceProvider implements Menstruations {

    private final MenstruationPersistenceEntityRepository repository;
    private final MenstruationPersistenceEntityAssembler assembler;
    private final MenstruationPersistenceEntityDisassembler disassembler;

    @Override
    public Optional<Menstruation> ofId(UUID id) {
        return repository.findById(id).map(disassembler::toDomainEntity);
    }

    @Override
    public boolean exists(UUID id) {
        return repository.existsById(id);
    }

    @Override
    public void add(Menstruation aggregateRoot) {
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

    @Override
    public void delete(Menstruation menstruation) {
        repository.delete(assembler.fromDomain(menstruation));
    }

    private void update (Menstruation aggregateRoot, MenstruationPersistenceEntity persistenceEntity) {
        persistenceEntity = assembler.merge(persistenceEntity, aggregateRoot);
        repository.save(persistenceEntity);
    }

    private void insert(Menstruation aggregateRoot) {
        MenstruationPersistenceEntity persistenceEntity = assembler.fromDomain(aggregateRoot);
        repository.save(persistenceEntity);
    }
}
