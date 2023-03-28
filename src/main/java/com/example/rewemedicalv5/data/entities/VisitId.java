package com.example.rewemedicalv5.data.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class VisitId implements Serializable {
    private LocalDateTime visitTime;
    private Patient patient;
    private Doctor doctor;
}
