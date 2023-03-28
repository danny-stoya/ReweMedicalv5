package com.example.rewemedicalv5.services;

import com.example.rewemedicalv5.data.entities.Insurance;
import com.example.rewemedicalv5.data.repositories.InsuranceRepository;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@AllArgsConstructor
public class InsuranceService {
    private final InsuranceRepository insuranceRepository;

    @PostConstruct
    private void init() {
        if (insuranceRepository.count() > 0) return;

        insuranceRepository.save(
                new Insurance(
                        LocalDate.of(2023, 1, 1),
                        LocalDate.of(2023, 12, 31)
                )
        );

    }
}
