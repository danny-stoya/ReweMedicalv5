package com.example.rewemedicalv5.data.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.NaturalId;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "patients")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SQLDelete(sql = "UPDATE patients set deleted = true where id = ?")
@Where(clause = "deleted=false")
public class Patient extends BaseEntity {
    @NotBlank
    @Column(nullable = false)
    private String name;

    @NotBlank
    @Size(min = 3)
    @NaturalId
    @Column(nullable = false, unique = true)
    private String uid;

    @ManyToOne
    private Doctor gp;

    @ColumnDefault("false")
    private boolean deleted = Boolean.FALSE;

}
