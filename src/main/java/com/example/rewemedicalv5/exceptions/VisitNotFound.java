package com.example.rewemedicalv5.exceptions;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class VisitNotFound extends EntityNotFound{
    public VisitNotFound(LocalDateTime dateTime) {
        super("No visits for " + dateTime.format(DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm")) + " found");
    }
    public VisitNotFound(Long id) {
        super("Visit with Id " + id + " not found");
    }
}
