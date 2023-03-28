package com.example.rewemedicalv5.data.dtos.diagnosis;

import jakarta.validation.constraints.NotBlank;

public record ViewDiagnosisDto(
        @NotBlank
        String code,

        @NotBlank
        String description
) {
}
