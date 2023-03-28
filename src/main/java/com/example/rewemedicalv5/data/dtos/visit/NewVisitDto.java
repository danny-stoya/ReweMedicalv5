package com.example.rewemedicalv5.data.dtos.visit;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.List;

public record NewVisitDto(
        //validate by time and doctor
        @NotNull
        @FutureOrPresent
        @DateTimeFormat(pattern = "dd-MM-yyyy HH:mm")
        LocalDateTime dateTime,

        @NotNull
        String patientUpin,

        @NotNull
        String doctorUpin,

        List<NewVisitDiagnosisDto> diagnoses

) {
}
