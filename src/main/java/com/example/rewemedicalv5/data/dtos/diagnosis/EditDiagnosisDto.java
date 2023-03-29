package com.example.rewemedicalv5.data.dtos.diagnosis;

import jakarta.validation.constraints.NotBlank;
import static com.example.rewemedicalv5.exceptions.FailedValidationMessage.INVALID_DIAGNOSIS_DESCRIPTION;

public record EditDiagnosisDto(
        @NotBlank(message = INVALID_DIAGNOSIS_DESCRIPTION)
        String description
) {
}
