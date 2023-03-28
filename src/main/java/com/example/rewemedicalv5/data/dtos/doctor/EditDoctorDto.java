package com.example.rewemedicalv5.data.dtos.doctor;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;

import java.time.LocalDate;
import java.util.Set;

import static com.example.rewemedicalv5.exceptions.InvalidValidationMessage.*;

public record EditDoctorDto(
        @NotBlank(message = INVALID_DOCTOR_NAME)
        String name,

        @NotNull(message = INVALID_BIRTHDAY)
        @Past(message = INVALID_BIRTHDAY_DATE)
        @JsonFormat(pattern = "yyyy-MM-dd")
        LocalDate birthDate,

        @NotNull(message = MANDATORY_ISGP)
        boolean isGp,

        Set<String> specialties
) {
}
