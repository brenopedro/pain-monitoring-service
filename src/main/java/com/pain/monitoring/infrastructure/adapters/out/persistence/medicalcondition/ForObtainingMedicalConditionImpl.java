package com.pain.monitoring.infrastructure.adapters.out.persistence.medicalcondition;

import com.pain.monitoring.core.domain.model.medicalcondition.MedicalConditionNotFoundException;
import com.pain.monitoring.core.ports.in.MedicalConditionOutput;
import com.pain.monitoring.core.ports.out.ForObtainingMedicalConditions;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class ForObtainingMedicalConditionImpl implements ForObtainingMedicalConditions {

    private final MedicalConditionPersistenceEntityRepository repository;
    private final ModelMapper modelMapper;

    @Override
    public MedicalConditionOutput findById(UUID id) {
        return repository.findById(id).map(
                medicalCondition -> modelMapper.map(medicalCondition, MedicalConditionOutput.class))
                .orElseThrow(MedicalConditionNotFoundException::new);
    }

    @Override
    public Boolean exists(UUID id) {
        return repository.existsById(id);
    }
}
