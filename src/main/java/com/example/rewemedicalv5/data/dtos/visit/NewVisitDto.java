package com.example.rewemedicalv5.data.dtos.visit;

import com.example.rewemedicalv5.exceptions.validations.VisitAvailability;
import com.example.rewemedicalv5.exceptions.validations.DoctorExist;
import com.example.rewemedicalv5.exceptions.validations.PatientExist;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;
import java.util.Set;

@VisitAvailability
public record NewVisitDto(
        @NotNull
        @FutureOrPresent
        @JsonSerialize(using = LocalDateTimeSerializer.class)
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        LocalDateTime visitTime,

        @NotBlank
        @Size(min = 3)
        @PatientExist
        String patientUid,

        @NotBlank
        @Size(min = 3)
        @DoctorExist
        String doctorUid,

        Set<String> diagnoses
//HttpMessageNotReadableException default 400 exception
) {
}
