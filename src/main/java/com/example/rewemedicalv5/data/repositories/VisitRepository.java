package com.example.rewemedicalv5.data.repositories;

import com.example.rewemedicalv5.data.entities.Visit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface VisitRepository extends JpaRepository<Visit, Long> {
    Optional<Visit> findByVisitTimeAndDoctor_Uid(LocalDateTime visitTime, String doctor_uid);

    List<Visit> findByDoctor_Uid(String uid);
}
