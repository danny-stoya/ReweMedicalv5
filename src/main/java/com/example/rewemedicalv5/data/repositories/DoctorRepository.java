package com.example.rewemedicalv5.data.repositories;


import com.example.rewemedicalv5.data.entities.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    Optional<Doctor> findByUid(String uid);

}
