package com.example.rewemedicalv5.data.dtos.patient;

import com.example.rewemedicalv5.data.dtos.insurance.ViewInsuranceDto;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.NonNull;

import java.util.Set;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record ViewPatientDto(
        @NonNull
        String uid,

        @NonNull
        String name,

        String gpUid,
        Set<ViewInsuranceDto> insurances
) {
}
