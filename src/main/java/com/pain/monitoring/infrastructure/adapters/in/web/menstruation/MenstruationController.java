package com.pain.monitoring.infrastructure.adapters.in.web.menstruation;

import com.pain.monitoring.core.ports.in.menstruation.ForManagingMenstruation;
import com.pain.monitoring.core.ports.in.menstruation.ForQueryingMenstruation;
import com.pain.monitoring.core.ports.in.menstruation.MenstruationInput;
import com.pain.monitoring.core.ports.in.menstruation.MenstruationOutput;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/health/menstruation-cycle")
@RequiredArgsConstructor
public class MenstruationController {

    private final ForManagingMenstruation managementService;
    private final ForQueryingMenstruation queryService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MenstruationOutput create(@RequestBody @Valid MenstruationInput input) {
        UUID id = managementService.create(input);
        return queryService.findById(id);
    }

    @GetMapping("/{id}")
    public MenstruationOutput findById(@PathVariable UUID id) {
        return queryService.findById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable UUID id) {
        managementService.delete(id);
    }

    @PutMapping("/{id}")
    public MenstruationOutput update(@PathVariable UUID id, @RequestBody @Valid MenstruationInput input) {
        managementService.update(id, input);
        return queryService.findById(id);
    }
}