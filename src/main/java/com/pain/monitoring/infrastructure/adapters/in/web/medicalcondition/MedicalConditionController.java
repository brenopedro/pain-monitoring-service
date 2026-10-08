package com.pain.monitoring.infrastructure.adapters.in.web.medicalcondition;

import com.pain.monitoring.core.ports.in.ForManagingMedicalCondition;
import com.pain.monitoring.core.ports.in.ForQueryingMedicalCondition;
import com.pain.monitoring.core.ports.in.MedicalConditionInput;
import com.pain.monitoring.core.ports.in.MedicalConditionOutput;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/health/medical-condition")
@RequiredArgsConstructor
public class MedicalConditionController {

    private final ForManagingMedicalCondition managementService;
    private final ForQueryingMedicalCondition queryService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MedicalConditionOutput create(@RequestBody @Valid MedicalConditionInput input) {
        UUID id = managementService.create(input);
        return queryService.findById(id);
    }

    @GetMapping("/{id}")
    public MedicalConditionOutput findById(@PathVariable UUID id) {
        return queryService.findById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable UUID id) {
        managementService.delete(id);
    }

    @PutMapping("/{id}")
    public MedicalConditionOutput update(@PathVariable UUID id, @RequestBody @Valid MedicalConditionInput input) {
        managementService.update(id, input);
        return queryService.findById(id);
    }
}
