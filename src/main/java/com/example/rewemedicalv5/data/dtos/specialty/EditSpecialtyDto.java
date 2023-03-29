package com.example.rewemedicalv5.data.dtos.specialty;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import static com.example.rewemedicalv5.exceptions.FailedValidationMessage.INVALID_SPECIALTY_NAME;
import static com.example.rewemedicalv5.exceptions.FailedValidationMessage.INVALID_SPECIALTY_NAME_LENGTH;

public record EditSpecialtyDto(
        @NotBlank(message = INVALID_SPECIALTY_NAME)
        @Size(min = 3, message = INVALID_SPECIALTY_NAME_LENGTH)
        String name
) {
}
