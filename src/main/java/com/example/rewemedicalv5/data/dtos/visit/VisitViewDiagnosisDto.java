package com.example.rewemedicalv5.data.dtos.visit;

import jakarta.validation.constraints.NotBlank;

public record VisitViewDiagnosisDto(
        @NotBlank
        String code,

        @NotBlank
        String description
) {
}
