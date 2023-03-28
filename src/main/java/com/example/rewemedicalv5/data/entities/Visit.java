package com.example.rewemedicalv5.data.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "visits")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Visit extends BaseEntity {
    @NotNull
    @FutureOrPresent
    @Column(nullable = false, name = "date_time")
    @DateTimeFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime dateTime;

    @NotNull
    @ManyToOne(optional = false)
    private Patient patient;

    @NotNull
    @ManyToOne(optional = false)
    private Doctor doctor;

    @OneToOne
    private Fee fee;

    @ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    private List<Diagnosis> diagnoses = new ArrayList<>();
}
