package com.example.rewemedicalv5.data.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import lombok.*;
import org.hibernate.annotations.NaturalId;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "doctors")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Doctor extends BaseEntity  {
    @NotBlank
    @Column(nullable = false)
    private String name;

    @NonNull
    @Past
    @Column(nullable = false, name = "birth_date")
    private LocalDate birthDate;

    @NonNull
    @NaturalId
    @Column(nullable = false, unique = true)
    private String uid;

    @Column(nullable = false, name = "is_gp")
    private boolean isGp;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<Specialty> specialties = new HashSet<>();

    public void addSpecialty(Specialty specialty) {
        specialties.add(specialty);
    }
}
