package com.example.rewemedicalv5.data.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "fees")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SQLDelete(sql = "UPDATE fees set deleted = true where id = ?")
@Where(clause = "deleted=false")
public class Fee extends BaseEntity {
    @NotNull
    @PositiveOrZero
    private BigDecimal value;

    @NotNull
    @PastOrPresent
    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    @NotNull
    @FutureOrPresent
    @Column(name = "end_date", nullable = false)
    private LocalDate endDate;

    @ColumnDefault("false")
    private boolean deleted = Boolean.FALSE;

}
