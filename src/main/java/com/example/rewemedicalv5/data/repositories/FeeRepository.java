package com.example.rewemedicalv5.data.repositories;

import com.example.rewemedicalv5.data.entities.Fee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;

public interface FeeRepository extends JpaRepository<Fee, Long> {
    @Query("select f from Fee f where :date between f.startDate and f.endDate")
    Fee findByDateBetween(LocalDate date);

    @Query("select f from Fee f where f.value = 0")
    Fee getInsuranceCover();
}
