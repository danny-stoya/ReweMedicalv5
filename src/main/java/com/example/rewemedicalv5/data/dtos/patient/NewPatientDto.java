package com.example.rewemedicalv5.data.dtos.patient;

import com.example.rewemedicalv5.exceptions.validations.UniquePatient;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import static com.example.rewemedicalv5.exceptions.FailedValidationMessage.*;

@UniquePatient
public record NewPatientDto(
        @NotNull(message = INVALID_PATIENT_NAME)
        String name,

        @NotNull(message = INVALID_UID)
        @Size(min = 3, message = INVALID_UID_LENGTH)
        String uid,

        String gpUid
) {
}
