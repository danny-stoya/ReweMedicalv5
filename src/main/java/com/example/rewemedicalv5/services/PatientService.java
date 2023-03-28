package com.example.rewemedicalv5.services;

import com.example.rewemedicalv5.data.dtos.insurance.ViewInsuranceDto;
import com.example.rewemedicalv5.data.dtos.patient.AddPatientInsuranceDto;
import com.example.rewemedicalv5.data.dtos.patient.NewPatientDto;
import com.example.rewemedicalv5.data.dtos.patient.UpdatePatientDto;
import com.example.rewemedicalv5.data.dtos.patient.ViewPatientDto;
import com.example.rewemedicalv5.data.entities.Insurance;
import com.example.rewemedicalv5.data.entities.Patient;
import com.example.rewemedicalv5.data.repositories.InsuranceRepository;
import com.example.rewemedicalv5.data.repositories.PatientRepository;
import com.example.rewemedicalv5.exceptions.PatientNotFound;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PatientService {
    private final PatientRepository patientRepository;
    private final InsuranceRepository insuranceRepository;
    private final DoctorService doctorService;

    public void create(NewPatientDto dto) {
        patientRepository.save(
                toEntity(dto)
        );
    }

    public List<ViewPatientDto> getAll() {
        return toViewList(
                patientRepository.findAll()
        );
    }

//    public ViewPatientDto findById(Long id) {
//        return toView(
//                patientRepository
//                .findById(id)
//                .orElseThrow(() -> new PatientNotFound(id))
//        );
//    }

    public ViewPatientDto update(String uid, UpdatePatientDto dto) {
        return toView(
                patientRepository.save(updatePatient(uid, dto))
        );
    }

//    public void delete(Long id) {
//        patientRepository.deleteById(id);
//    }

    public void delete(String uid) {
        patientRepository.delete(findByUid(uid));
    }

    public ViewPatientDto findViewByUid(String uid) {
        return toView(findByUid(uid));
    }

    public Patient findByUid(String uid) {
        return patientRepository
                .findByUid(uid)
                .orElseThrow(() -> new PatientNotFound(uid)
                );
    }

    private Patient toEntity(NewPatientDto dto) {
        return new Patient(
                dto.name(),
                dto.uid(),
                dto.gpUid() == null ? null : doctorService.findByUid(dto.gpUid()),
                Set.of()
        );
    }

    private ViewPatientDto toView(Patient patient) {
        return new ViewPatientDto(
                patient.getUid(),
                patient.getName(),
                patient.getGp() == null ? null : patient.getGp().getUid(),
                patient.getInsurances().stream().map(insurance -> new ViewInsuranceDto(
                        insurance.getId(),
                        insurance.getStartDate(),
                        insurance.getEndDate()
                )).collect(Collectors.toSet())
        );
    }

    private List<ViewPatientDto> toViewList(List<Patient> patients) {
        return patients
                .stream()
                .map(this::toView)
                .toList();
    }

    private Patient updatePatient(String uid, UpdatePatientDto dto) {
        return findByUid(uid)
                .setName(dto.name())
                .setGp((dto.gpUid() == null) ? null :
                        doctorService.findByUid(dto.gpUid())
                );
    }

    public ViewPatientDto addInsurance(String uid, AddPatientInsuranceDto dto) {
        Patient patient = findByUid(uid);
        insuranceRepository.save(new Insurance(dto.startDate(), dto.endDate(), patient));
        return toView(patient);
    }
}
