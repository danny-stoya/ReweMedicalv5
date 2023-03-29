package com.example.rewemedicalv5.data.dtos.insurance;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record ViewInsuranceDto(
        @NotNull
        Long id,

        @NotNull
        LocalDate startDate,

        @NotNull
        LocalDate endDate
) {
}
