package com.pain.monitoring.core.application.medicalcondition;

import com.pain.monitoring.core.domain.model.medicalcondition.MedicalCondition;
import com.pain.monitoring.core.domain.model.medicalcondition.MedicalConditions;
import com.pain.monitoring.core.ports.in.ForManagingMedicalCondition;
import com.pain.monitoring.core.ports.in.MedicalConditionInput;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MedicalConditionApplicationManagementApplicationService implements ForManagingMedicalCondition {

    private final MedicalConditions medicalConditions;

    @Override
    public UUID create(MedicalConditionInput input) {
        MedicalCondition medicalCondition = MedicalCondition.brandNew()
                .name(input.getName())
                .startDate(input.getStartDate())
                .endDate(input.getEndDate())
                .onGoing(input.getOnGoing())
                .notes(input.getNotes())
                .build();

        medicalConditions.add(medicalCondition);


        return medicalCondition.id();
    }
}
