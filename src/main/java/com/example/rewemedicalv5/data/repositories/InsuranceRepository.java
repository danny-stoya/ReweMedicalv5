package com.example.rewemedicalv5.data.repositories;

import com.example.rewemedicalv5.data.entities.Insurance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InsuranceRepository extends JpaRepository<Insurance, Long> {
}
