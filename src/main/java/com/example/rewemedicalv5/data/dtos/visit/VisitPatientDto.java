package com.example.rewemedicalv5.data.dtos.visit;

import lombok.NonNull;

public record VisitPatientDto(
        String name,
        boolean hasInsurance,
        String upin
) {
}
