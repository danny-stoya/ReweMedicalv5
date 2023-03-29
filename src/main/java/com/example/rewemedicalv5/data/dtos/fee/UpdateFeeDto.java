package com.example.rewemedicalv5.data.dtos.fee;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

import java.math.BigDecimal;

public record UpdateFeeDto(
        @NotNull
        @Positive
        BigDecimal value
) {
}
