package com.example.rewemedicalv5.data.dtos.diagnosis;

import com.example.rewemedicalv5.exceptions.validations.UniqueDiagnosis;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import static com.example.rewemedicalv5.exceptions.FailedValidationMessage.*;

@UniqueDiagnosis
public record NewDiagnosisDto(
        @Size(min = 3, message = INVALID_DIAGNOSIS_CODE_LENGTH)
        String code,

        @NotBlank(message = INVALID_DIAGNOSIS_DESCRIPTION)
        String description
) {
}
