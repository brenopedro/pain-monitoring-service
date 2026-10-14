package com.pain.monitoring.infrastructure.adapters.out.persistence.menstruation;

import com.pain.monitoring.core.domain.model.menstruation.Menstruation;
import com.pain.monitoring.core.domain.model.menstruation.MenstruationNotFoundException;
import com.pain.monitoring.core.ports.out.menstruation.ForObtainingMenstruations;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class ForObtainingMenstruationsImpl implements ForObtainingMenstruations {

    private final MenstruationPersistenceEntityRepository repository;
    private final MenstruationPersistenceEntityDisassembler disassembler;

    @Override
    public Menstruation findById(UUID id) {
        return repository.findById(id).map(disassembler::toDomainEntity)
                .orElseThrow(MenstruationNotFoundException::new);
    }

    @Override
    public Boolean exists(UUID id) {
        return repository.existsById(id);
    }
}
