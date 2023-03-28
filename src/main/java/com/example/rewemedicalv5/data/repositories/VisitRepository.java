package com.example.rewemedicalv5.data.repositories;

import com.example.rewemedicalv5.data.entities.Visit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VisitRepository extends JpaRepository<Visit, Long> {
}
