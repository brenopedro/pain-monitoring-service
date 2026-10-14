package com.pain.monitoring.core.application.medicalcondition;

import com.pain.monitoring.core.ports.in.medicalcondition.ForQueryingMedicalCondition;
import com.pain.monitoring.core.ports.in.medicalcondition.MedicalConditionOutput;
import com.pain.monitoring.core.ports.out.medicalcondition.ForObtainingMedicalConditions;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MedicalConditionQueryApplicationService implements ForQueryingMedicalCondition {

    private final ForObtainingMedicalConditions obtainingMedicalConditions;
    private final ModelMapper mapper;

    @Override
    public MedicalConditionOutput findById(UUID id) {
        return mapper.map(obtainingMedicalConditions.findById(id), MedicalConditionOutput.class);
    }

    @Override
    public Boolean exists(UUID id) {
        return obtainingMedicalConditions.exists(id);
    }
}
