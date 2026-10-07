package com.pain.monitoring.infrastructure.adapters.out.persistence.medicalcondition;

import com.pain.monitoring.core.domain.model.medicalcondition.MedicalCondition;
import com.pain.monitoring.core.domain.model.medicalcondition.MedicalConditionNotFoundException;
import com.pain.monitoring.core.ports.out.ForObtainingMedicalConditions;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class ForObtainingMedicalConditionImpl implements ForObtainingMedicalConditions {

    private final MedicalConditionPersistenceEntityRepository repository;
    private final MedicalConditionPersistenceEntityDisassembler disassembler;

    @Override
    public MedicalCondition findById(UUID id) {
        return repository.findById(id).map(disassembler::toDomainEntity)
                .orElseThrow(MedicalConditionNotFoundException::new);
    }

    @Override
    public Boolean exists(UUID id) {
        return repository.existsById(id);
    }
}
