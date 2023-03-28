package com.example.rewemedicalv5.data.repositories;

import com.example.rewemedicalv5.data.entities.Fee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Optional;

public interface FeeRepository extends JpaRepository<Fee, Long> {
}
