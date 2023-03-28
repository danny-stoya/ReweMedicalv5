package com.example.rewemedicalv5.data.dtos.visit;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.NonNull;

import java.time.LocalDate;

public record VisitDoctorDto(
        String uid,
        String name

) {
}
