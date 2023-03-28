package com.example.rewemedicalv5.data.repositories;

import com.example.rewemedicalv5.data.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    Optional<Patient> findByUid(String uid);
}
