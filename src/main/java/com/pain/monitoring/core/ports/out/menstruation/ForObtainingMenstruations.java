package com.pain.monitoring.core.ports.out.menstruation;

import com.pain.monitoring.core.domain.model.menstruation.Menstruation;

import java.util.UUID;

public interface ForObtainingMenstruations {
    Menstruation findById(UUID id);

    Boolean exists(UUID id);
}
