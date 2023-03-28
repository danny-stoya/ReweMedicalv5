package com.example.rewemedicalv5.data.dtos.visit;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

public record NewVisitDto(
        //validate by time and doctor
        @NotNull
        @FutureOrPresent
        @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
        LocalDateTime dateTime,

        @NotNull
        String patientUid,

        @NotNull
        String doctorUid,

        Set<String> diagnoses

) {
}
