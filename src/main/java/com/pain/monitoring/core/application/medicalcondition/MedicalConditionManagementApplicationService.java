package com.pain.monitoring.core.application.medicalcondition;

import com.pain.monitoring.core.domain.model.medicalcondition.MedicalCondition;
import com.pain.monitoring.core.ports.in.ForManagingMedicalCondition;
import com.pain.monitoring.core.ports.in.MedicalConditionInput;
import com.pain.monitoring.core.ports.out.ForHandlingMedicalConditions;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MedicalConditionManagementApplicationService implements ForManagingMedicalCondition {

    private final ForHandlingMedicalConditions handlingMedicalConditions;

    @Override
    public UUID create(MedicalConditionInput input) {
        MedicalCondition medicalCondition = MedicalCondition.brandNew()
                .name(input.getName())
                .startDate(input.getStartDate())
                .endDate(input.getEndDate())
                .onGoing(input.getOnGoing())
                .notes(input.getNotes())
                .build();

        handlingMedicalConditions.add(medicalCondition);


        return medicalCondition.id();
    }

    @Override
    public void delete(UUID id) {
        handlingMedicalConditions.delete(id);
    }
}
