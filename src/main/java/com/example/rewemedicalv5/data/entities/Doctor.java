package com.example.rewemedicalv5.data.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.NaturalId;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "doctors")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SQLDelete(sql = "UPDATE doctors set deleted = true where uid = ?")
//@SQLDelete(sql = "UPDATE doctors set deleted = true where id = ?")
@Where(clause = "deleted=false")
public class Doctor extends BaseEntity  {
    @NotBlank
    @Column(nullable = false)
    private String name;

    @NonNull
    @Past
    @Column(nullable = false, name = "birth_date")
    private LocalDate birthDate;

    //buggy AF
    @NonNull
    @NaturalId
    @Column(nullable = false, unique = true)
    private String uid;

    @Column(nullable = false, name = "is_gp")
    private boolean isGp;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<Specialty> specialties = new HashSet<>();

    @ColumnDefault("false")
    private boolean deleted = Boolean.FALSE;
}
