package com.pain.monitoring.infrastructure.adapters.in.web.medicalcondition;

import com.pain.monitoring.core.ports.in.ForManagingMedicalCondition;
import com.pain.monitoring.core.ports.in.MedicalConditionInput;
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

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UUID create(@RequestBody @Valid MedicalConditionInput input) {
        return managementService.create(input);
    }
}
