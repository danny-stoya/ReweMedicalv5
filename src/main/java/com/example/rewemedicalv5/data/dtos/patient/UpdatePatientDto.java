package com.example.rewemedicalv5.data.dtos.patient;

import lombok.NonNull;

public record UpdatePatientDto(
        @NonNull
        String name,

        @NonNull
        boolean hasInsurance,

        @NonNull
        String uid,

        String gpUid
) {
}
