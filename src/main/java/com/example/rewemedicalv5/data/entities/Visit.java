package com.example.rewemedicalv5.data.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "visits")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SQLDelete(sql = "UPDATE visits set deleted = true where id = ?")
@Where(clause = "deleted=false")
public class Visit extends BaseEntity {
    @NotNull
    @FutureOrPresent
    @Column(name = "visit_time", nullable = false)
    private LocalDateTime visitTime;

    @NotNull
    @ManyToOne(optional = false)
    private Patient patient;

    @NotNull
    @ManyToOne(optional = false)
    private Doctor doctor;

    @OneToOne
    private Fee fee;

    @ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    private Set<Diagnosis> diagnoses = new HashSet<>();

    @ColumnDefault("false")
    private boolean deleted = Boolean.FALSE;

}
