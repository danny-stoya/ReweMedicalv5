package com.example.rewemedicalv5.data.dtos.doctor;

import com.example.rewemedicalv5.exceptions.validations.UniqueDoctorUID;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;

import java.time.LocalDate;
import java.util.Set;

import static com.example.rewemedicalv5.exceptions.InvalidValidationMessage.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record NewDoctorDto(
        @NotBlank(message = INVALID_DOCTOR_NAME)
        String name,

        @NotNull(message = INVALID_BIRTHDAY)
        @Past(message = INVALID_BIRTHDAY)
        @JsonFormat(pattern = "yyyy-MM-dd")
        LocalDate birthDate,

        @NotBlank(message = INVALID_UID)
        @UniqueDoctorUID
        String uid,

        @NotNull
        boolean isGp,

        Set<String> specialties
) {
}
