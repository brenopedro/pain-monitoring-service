package com.pain.monitoring.core.application.medicalcondition;

import com.pain.monitoring.core.domain.model.medicalcondition.MedicalCondition;
import com.pain.monitoring.core.domain.model.medicalcondition.MedicalConditionNotFoundException;
import com.pain.monitoring.core.domain.model.medicalcondition.MedicalConditions;
import com.pain.monitoring.core.ports.in.ForManagingMedicalCondition;
import com.pain.monitoring.core.ports.in.MedicalConditionInput;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MedicalConditionManagementApplicationService implements ForManagingMedicalCondition {

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

    @Override
    public void delete(@NotNull UUID id) {
        MedicalCondition medicalCondition = medicalConditions.ofId(id)
                .orElseThrow(MedicalConditionNotFoundException::new);
        medicalConditions.delete(medicalCondition);
    }

    @Override
    public void update(@NotNull UUID id, @NotNull MedicalConditionInput input) {
        MedicalCondition medicalCondition = medicalConditions.ofId(id)
                .orElseThrow(MedicalConditionNotFoundException::new);

        medicalCondition.changeName(input.getName());
        medicalCondition.changeDates(input.getStartDate(), input.getEndDate(), input.getOnGoing());
        medicalCondition.changeNotes(input.getNotes());

        medicalConditions.add(medicalCondition);
    }


}
