package com.pain.monitoring.core.application.menstruation;

import com.pain.monitoring.core.ports.in.menstruation.ForQueryingMenstruation;
import com.pain.monitoring.core.ports.in.menstruation.MenstruationOutput;
import com.pain.monitoring.core.ports.out.menstruation.ForObtainingMenstruations;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MenstruationQueryApplicationService implements ForQueryingMenstruation {

    private final ForObtainingMenstruations obtainingMenstruations;
    private final ModelMapper mapper;

    @Override
    public MenstruationOutput findById(UUID id) {
        return mapper.map(obtainingMenstruations.findById(id), MenstruationOutput.class);
    }

    @Override
    public Boolean exists(UUID id) {
        return obtainingMenstruations.exists(id);
    }
}
