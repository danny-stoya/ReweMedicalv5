package com.example.rewemedicalv5.data.repositories;

import com.example.rewemedicalv5.data.entities.Diagnosis;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DiagnosisRepository extends JpaRepository<Diagnosis, Long> {
    Optional<Diagnosis> findByCode(String code);
}
