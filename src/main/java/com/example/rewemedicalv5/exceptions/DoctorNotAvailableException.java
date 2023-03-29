package com.example.rewemedicalv5.exceptions;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class DoctorNotAvailableException extends RuntimeException {
    public DoctorNotAvailableException(LocalDateTime date) {
        super(String.format(
                "Doctor not available on %s%s. Please select another date.",
                date.toString().replace("T", " at "),
                date.getHour() < 12 ? "AM" : "PM"
                )
        );
    }
}
