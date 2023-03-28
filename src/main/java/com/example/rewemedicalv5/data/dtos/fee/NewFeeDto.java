package com.example.rewemedicalv5.data.dtos.fee;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.NonNull;

import java.math.BigDecimal;
import java.time.LocalDate;

public record NewFeeDto(
        @NotNull
        @PositiveOrZero
        BigDecimal value
) {
}
