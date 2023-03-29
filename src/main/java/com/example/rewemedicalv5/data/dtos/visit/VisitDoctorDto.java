package com.example.rewemedicalv5.data.dtos.visit;

import jakarta.validation.constraints.NotNull;


public record VisitDoctorDto(
        @NotNull
        String uid,
        @NotNull
        String name
) {
}
