package com.example.rewemedicalv5.data.dtos.patient;

import com.example.rewemedicalv5.data.dtos.insurance.NewInsuranceDto;
import lombok.NonNull;

import java.util.Set;

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
