package com.example.rewemedicalv5.data.dtos.patient;

import java.time.LocalDate;

public record AddPatientInsuranceDto(
        LocalDate startDate,
        LocalDate endDate
) {
}
