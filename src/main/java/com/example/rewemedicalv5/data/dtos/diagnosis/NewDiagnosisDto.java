package com.example.rewemedicalv5.data.dtos.diagnosis;

import com.example.rewemedicalv5.exceptions.InvalidValidationMessage;
import com.example.rewemedicalv5.exceptions.validations.UniqueDiagnosisCode;
import jakarta.validation.constraints.NotBlank;

import static com.example.rewemedicalv5.exceptions.InvalidValidationMessage.INVALID_DIAGNOSIS_CODE;
import static com.example.rewemedicalv5.exceptions.InvalidValidationMessage.INVALID_DIAGNOSIS_DESCRIPTION;

public record NewDiagnosisDto(
        @NotBlank(message = INVALID_DIAGNOSIS_CODE)
        @UniqueDiagnosisCode
        String code,

        @NotBlank(message = INVALID_DIAGNOSIS_DESCRIPTION)
        String description
) {
}
