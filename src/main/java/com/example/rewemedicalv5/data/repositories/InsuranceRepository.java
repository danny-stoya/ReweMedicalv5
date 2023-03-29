package com.example.rewemedicalv5.data.repositories;

import com.example.rewemedicalv5.data.entities.Insurance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface InsuranceRepository extends JpaRepository<Insurance, Long> {
    @Query(""" 
                     select case when count(i)> 0 then true else false end
                     from Insurance i where i.patient.uid = :uid and :visitDate between i.startDate and i.endDate
            """)
    boolean existForPatientAndDate(String uid, LocalDate visitDate);

    List<Insurance> findAllByPatient_uid(String uid);
}
