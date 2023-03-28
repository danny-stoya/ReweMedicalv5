package com.example.rewemedicalv5.data.dtos.insurance;

import java.time.LocalDate;

public record ViewInsuranceDto(
        Long id,
        LocalDate startDate,
        LocalDate endDate
) {
}
