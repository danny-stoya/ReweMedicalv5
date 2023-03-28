package com.example.rewemedicalv5.data.dtos.visit;

import com.example.rewemedicalv5.data.dtos.doctor.ViewDoctorDto;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public record VisitViewDto(
        @NotNull
        Long id,

        @NotNull
        @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
        LocalDateTime dateTime,

        @NotNull
        VisitPatientDto patient,

        @NotNull
        VisitDoctorDto doctor,

        @NotNull
        BigDecimal fee,

        List<VisitViewDiagnosisDto> diagnoses
) {
}
