package com.example.rewemedicalv5.data.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.NaturalId;

import java.util.Set;

@Entity
@Table(name = "patients")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Patient extends BaseEntity {
    @NonNull
    @Column(nullable = false)
    private String name;

    @NonNull
    @NaturalId
    @Column(nullable = false, unique = true)
    private String uid;

    @ManyToOne
    private Doctor gp;

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    Set<Insurance> insurances;
}
