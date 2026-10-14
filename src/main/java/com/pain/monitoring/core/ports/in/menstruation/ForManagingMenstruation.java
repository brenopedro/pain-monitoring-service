package com.pain.monitoring.core.ports.in.menstruation;

import java.util.UUID;

public interface ForManagingMenstruation {

    UUID create(MenstruationInput input);
    void delete(UUID id);
    void update(UUID id, MenstruationInput input);
}
