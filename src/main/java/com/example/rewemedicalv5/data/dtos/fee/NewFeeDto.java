package com.example.rewemedicalv5.data.dtos.fee;

import jakarta.validation.constraints.*;
import lombok.NonNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDate;

public record NewFeeDto(
        @NotNull
        @Positive
        BigDecimal value,

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
