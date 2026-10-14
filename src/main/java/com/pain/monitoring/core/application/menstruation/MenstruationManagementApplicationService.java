package com.pain.monitoring.core.application.menstruation;

import com.pain.monitoring.core.domain.model.menstruation.Menstruation;
import com.pain.monitoring.core.domain.model.menstruation.MenstruationNotFoundException;
import com.pain.monitoring.core.domain.model.menstruation.Menstruations;
import com.pain.monitoring.core.ports.in.menstruation.ForManagingMenstruation;
import com.pain.monitoring.core.ports.in.menstruation.MenstruationInput;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MenstruationManagementApplicationService implements ForManagingMenstruation {

    private final Menstruations menstruations;

    @Override
    public UUID create(MenstruationInput input) {
        Menstruation menstruation = Menstruation.brandNew()
                .startDate(input.getStartDate())
                .endDate(input.getEndDate())
                .onGoing(input.getOnGoing())
                .notes(input.getNotes())
                .build();

        menstruations.add(menstruation);

        return menstruation.id();
    }

    @Override
    public void delete(@NotNull UUID id) {
        Menstruation menstruation = menstruations.ofId(id)
                .orElseThrow(MenstruationNotFoundException::new);
        menstruations.delete(menstruation);
    }

    @Override
    public void update(@NotNull UUID id, @NotNull MenstruationInput input) {
        Menstruation menstruation = menstruations.ofId(id)
                .orElseThrow(MenstruationNotFoundException::new);

        menstruation.changeDates(input.getStartDate(), input.getEndDate(), input.getOnGoing());
        menstruation.changeNotes(input.getNotes());

        menstruations.add(menstruation);
    }


}
