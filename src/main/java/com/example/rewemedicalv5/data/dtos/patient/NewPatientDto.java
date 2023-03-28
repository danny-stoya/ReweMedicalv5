package com.example.rewemedicalv5.data.dtos.patient;

import com.example.rewemedicalv5.data.dtos.insurance.NewInsuranceDto;
import com.example.rewemedicalv5.exceptions.InvalidValidationMessage;
import com.example.rewemedicalv5.exceptions.validations.UniquePatientUid;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotNull;
import lombok.NonNull;

import java.util.Set;

import static com.example.rewemedicalv5.exceptions.InvalidValidationMessage.INVALID_PATIENT_NAME;
import static com.example.rewemedicalv5.exceptions.InvalidValidationMessage.INVALID_UID;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record NewPatientDto(
        @NotNull(message = INVALID_PATIENT_NAME)
        String name,

        @NotNull(message = INVALID_UID)
        @UniquePatientUid
        String uid,

        String gpUid
) {
}
