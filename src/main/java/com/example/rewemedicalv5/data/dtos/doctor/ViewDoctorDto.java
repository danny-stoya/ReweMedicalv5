package com.example.rewemedicalv5.data.dtos.doctor;

import com.example.rewemedicalv5.data.dtos.specialty.ViewSpecialtyDto;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotBlank;
import lombok.NonNull;

import java.time.LocalDate;
import java.util.Set;

public record ViewDoctorDto(
        @NotBlank
        String uid,

        @NonNull
        String name,

        @JsonFormat(pattern = "yyyy-MM-dd")
        LocalDate birthDate,

        @NonNull
        Boolean isGp,

        Set<ViewSpecialtyDto> specialties
) {
}
