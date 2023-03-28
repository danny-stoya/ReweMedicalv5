package com.example.rewemedicalv5.data.dtos.insurance;

import java.time.LocalDate;

public record NewInsuranceDto(
        LocalDate startDate,
        LocalDate endDate
) {
}
