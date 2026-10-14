package com.pain.monitoring.core.domain.model.menstruation;

import com.pain.monitoring.core.domain.model.DomainEntityNotFoundException;

import java.util.UUID;

public class MenstruationNotFoundException extends DomainEntityNotFoundException {

    public MenstruationNotFoundException() {
    }

    public MenstruationNotFoundException(UUID id) {
        super(String.format("Menstruation with id %s does not exist", id));
    }
}
