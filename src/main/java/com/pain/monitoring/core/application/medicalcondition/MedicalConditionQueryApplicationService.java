package com.pain.monitoring.core.application.medicalcondition;

import com.pain.monitoring.core.ports.in.ForQueryingMedicalCondition;
import com.pain.monitoring.core.ports.in.MedicalConditionOutput;
import com.pain.monitoring.core.ports.out.ForObtainingMedicalConditions;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class MedicalConditionQueryApplicationService implements ForQueryingMedicalCondition {

    private final ForObtainingMedicalConditions obtainingMedicalConditions;

    @Override
    public MedicalConditionOutput findById(UUID id) {
        return obtainingMedicalConditions.findById(id);
    }
}
