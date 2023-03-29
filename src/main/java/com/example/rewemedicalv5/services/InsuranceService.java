package com.example.rewemedicalv5.services;

import com.example.rewemedicalv5.data.dtos.insurance.NewInsuranceDto;
import com.example.rewemedicalv5.data.entities.Insurance;
import com.example.rewemedicalv5.data.entities.Patient;
import com.example.rewemedicalv5.data.repositories.InsuranceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class InsuranceService {
    private final InsuranceRepository insuranceRepository;

    public boolean existForPatientAndDate(String uid, LocalDate visitDate) {
        return insuranceRepository.existForPatientAndDate(uid, visitDate);
    }

    public void addInsurance(Patient patient, NewInsuranceDto dto) {
        insuranceRepository.save(new Insurance(dto.startDate(), dto.endDate(), patient, false));
    }

    public List<Insurance> findAllForPatient(String uid) {
        return insuranceRepository.findAllByPatient_uid(uid);
    }

    public void deleteInsurance(Long id) {
        insuranceRepository.deleteById(id);
    }


}
