package com.example.rewemedicalv5.data.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@Entity
@Table(name = "fees_timeline")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FeeTimeline extends BaseEntity{
    private LocalDate startDate;

    private LocalDate endDate;

    @ManyToOne
    private Fee fee;

}
