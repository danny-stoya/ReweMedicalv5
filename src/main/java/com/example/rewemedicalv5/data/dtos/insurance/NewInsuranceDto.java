package com.example.rewemedicalv5.data.dtos.insurance;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public record NewInsuranceDto(
        @NotNull
        @PastOrPresent
        @DateTimeFormat(pattern = "yyyy-MM-dd")
        LocalDate startDate,
        
        @NotNull
        @FutureOrPresent
        @DateTimeFormat(pattern = "yyyy-MM-dd")
        LocalDate endDate
) {
}
