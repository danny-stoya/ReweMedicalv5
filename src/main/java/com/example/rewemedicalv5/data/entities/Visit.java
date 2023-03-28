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
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "visits")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@IdClass(VisitId.class)
public class Visit {
    @Id
    @NotNull
    @FutureOrPresent
    @Column(nullable = false, name = "date_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime visitTime;

    @Id
    @NotNull
    @ManyToOne(optional = false)
    private Patient patient;

    @Id
    @NotNull
    @ManyToOne(optional = false)
    private Doctor doctor;

    @OneToOne
    private Fee fee;

    @ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    private Set<Diagnosis> diagnoses = new HashSet<>();
}
