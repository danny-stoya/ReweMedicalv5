package com.example.rewemedicalv5.data.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Table(name = "specialties")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SQLDelete(sql = "UPDATE specialties set deleted = true where name = ?")
@Where(clause = "deleted=false")
public class Specialty extends BaseEntity{
    @NotBlank
    @Column(nullable = false, unique = true)
    private String name;

    @ColumnDefault("false")
    private boolean deleted = Boolean.FALSE;

}
