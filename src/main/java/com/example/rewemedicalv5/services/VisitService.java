package com.example.rewemedicalv5.services;

import com.example.rewemedicalv5.data.dtos.diagnosis.ViewDiagnosisDto;
import com.example.rewemedicalv5.data.dtos.visit.*;
import com.example.rewemedicalv5.data.entities.Diagnosis;
import com.example.rewemedicalv5.data.entities.Fee;
import com.example.rewemedicalv5.data.entities.Patient;
import com.example.rewemedicalv5.data.entities.Visit;
import com.example.rewemedicalv5.data.repositories.VisitRepository;
import com.example.rewemedicalv5.exceptions.DoctorNotFound;
import com.example.rewemedicalv5.exceptions.VisitNotFound;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class VisitService {
    private final VisitRepository visitRepository;
    private final DoctorService doctorService;
    private final PatientService patientService;
    private final FeeService feeService;
    private final DiagnosisService diagnosisService;

    public Long create(NewVisitDto dto) {
        return visitRepository.save(toEntity(dto)).getId();
    }

    private Visit toEntity(NewVisitDto dto) {
        var patient = patientService.findByUid(dto.patientUid());
        var time = LocalDate.of(dto.visitTime().getYear(), dto.visitTime().getMonth(), dto.visitTime().getDayOfMonth());

        return new Visit(
                dto.visitTime(),
                patient,
                doctorService.findByUid(dto.doctorUid()),
                getFee(patient, LocalDate.of(time.getYear(), time.getMonth(), time.getDayOfMonth())),
                getDiagnoses(dto),
                false
        );
    }

    private Fee getFee(Patient patient, LocalDate time) {
        return patientService.hasInsurance(patient.getUid(), time) ?
                feeService.getInsuranceCover() :
                feeService.getFeeByDate(time);
    }

    private Set<Diagnosis> getDiagnoses(NewVisitDto dto) {
        return dto.diagnoses().stream().map(diagnosisService::findByCode).collect(Collectors.toSet());
    }

    private ViewVisitDto toView(Visit visit) {
        return new ViewVisitDto(
                visit.getId(),
                visit.getVisitTime(),
                new VisitPatientDto(
                        visit.getPatient().getUid(),
                        visit.getPatient().getName()
                ),
                new VisitDoctorDto(
                        visit.getDoctor().getUid(),
                        visit.getDoctor().getName()
                ),
                visit.getFee().getValue(),
                visit.getDiagnoses().stream().map(diagnosis -> new ViewDiagnosisDto(
                        diagnosis.getCode(),
                        diagnosis.getDescription()
                )).collect(Collectors.toSet())
        );
    }

    public List<ViewVisitDto> getAll() {
        return toViewList(
                visitRepository.findAll()
        );
    }

    private List<ViewVisitDto> toViewList(List<Visit> all) {
        return all.stream().map(this::toView).toList();
    }

    public List<ViewVisitDto> findViewByDoctor(String doctor) {
        return toViewList(
                visitRepository.findByDoctor_Uid(doctor)
        );

    }

    public void delete(Long id) {
        visitRepository.deleteById(id);
    }

//    public Optional<ViewVisitDto> findByTimeAndDoctor(LocalDateTime time, String uid) {
//        return Optional.of(toView(
//                visitRepository
//                        .findByVisitTimeAndDoctor_Uid(time, uid).get()
//                )
//        );
//    }

    public ViewVisitDto findById(Long id) {
        return toView(visitRepository
                .findById(id).orElseThrow(() -> new VisitNotFound(id))
        );
    }
}
