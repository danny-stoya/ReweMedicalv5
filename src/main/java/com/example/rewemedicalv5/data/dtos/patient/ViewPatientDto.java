package com.example.rewemedicalv5.data.dtos.patient;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.NonNull;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record ViewPatientDto(
        @NonNull
        String uid,

        @NonNull
        String name,

        String gpUid
) {
}
