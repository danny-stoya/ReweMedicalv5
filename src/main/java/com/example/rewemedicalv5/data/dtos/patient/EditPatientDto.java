package com.example.rewemedicalv5.data.dtos.patient;

import lombok.NonNull;

public record EditPatientDto(
        @NonNull
        String name,

        String gpUid
) {
}
