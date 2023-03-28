package com.example.rewemedicalv5.data.repositories;


import com.example.rewemedicalv5.data.entities.Specialty;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpecialtyRepository extends JpaRepository<Specialty, Long> {
    Optional<Specialty> findByName(String name);
}
