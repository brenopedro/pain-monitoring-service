package com.pain.monitoring.core.ports.in.menstruation;

import java.util.UUID;

public interface ForQueryingMenstruation {
    MenstruationOutput findById(UUID id);

    Boolean exists(UUID id);
}
