package com.example.rewemedicalv5.data.dtos.visit;

import com.example.rewemedicalv5.data.dtos.diagnosis.ViewDiagnosisDto;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

public record ViewVisitDto(
        @NotNull
        Long id,

        @NotNull
        @JsonSerialize(using = LocalDateTimeSerializer.class)
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        @JsonProperty()
        LocalDateTime time,

        @NotNull
        VisitPatientDto patient,

        @NotNull
        VisitDoctorDto doctor,

        @NotNull
        BigDecimal fee,

        Set<ViewDiagnosisDto> diagnoses
) {
}
