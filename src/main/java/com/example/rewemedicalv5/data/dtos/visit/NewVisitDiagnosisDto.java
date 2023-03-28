package com.example.rewemedicalv5.data.dtos.visit;

import jakarta.validation.constraints.NotBlank;

public record NewVisitDiagnosisDto(
        @NotBlank
        String code
) {
}
