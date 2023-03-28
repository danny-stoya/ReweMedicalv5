package com.example.rewemedicalv5.services;

import com.example.rewemedicalv5.data.dtos.visit.*;
import com.example.rewemedicalv5.data.entities.Diagnosis;
import com.example.rewemedicalv5.data.entities.Visit;
import com.example.rewemedicalv5.data.repositories.VisitRepository;
import com.example.rewemedicalv5.exceptions.VisitNotFound;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

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

    public List<VisitViewDto> getAll() {
        return toViewList(
                visitRepository.findAll()
        );
    }

    private List<VisitViewDto> toViewList(List<Visit> all) {
       return all
               .stream()
               .map(this::toView)
               .toList();
    }

    public VisitViewDto findById(Long id) {
        return toView(
                visitRepository
                        .findById(id)
                        .orElseThrow(() -> new VisitNotFound(id))
        );
    }

//    public VisitViewDto update(Long id, UpdateDoctorDto dto) {
//        return toView(
//                visitRepository.save(
//                        updateDoctor(udin, dto)
//                )
//        );
//    }

    public void delete(Long id) {
        visitRepository.deleteById(id);
    }

    private Visit toEntity(NewVisitDto dto) {
        var patient = patientService.findByUid(dto.patientUpin());
        return new Visit(
                dto.dateTime(),
                patient,
                doctorService.findByUid(dto.doctorUpin()),
                patient.isHasInsurance() ? feeService.geInsuranceCover() : feeService.getDefaultFee(),
                getDiagnoses(dto)
        );
    }

    private VisitViewDto toView(Visit visit) {
        return new VisitViewDto(
                visit.getId(),
                visit.getDateTime(),
                getPatient(visit),
                getDoctor(visit),
                visit.getPatient().isHasInsurance() ? feeService.geInsuranceCover().getValue() : feeService.getDefaultFee().getValue(),
                getDiagnoses(visit)
        );
    }

    private static List<VisitViewDiagnosisDto> getDiagnoses(Visit visit) {
        return visit.getDiagnoses().stream()
                .map(diagnosis -> new VisitViewDiagnosisDto(
                        diagnosis.getCode(),
                        diagnosis.getDescription()

                ))
                .toList();
    }

    private static VisitDoctorDto getDoctor(Visit visit) {
        return new VisitDoctorDto(
                visit.getDoctor().getName(),
                visit.getDoctor().getUid()
        );
    }

    private static VisitPatientDto getPatient(Visit visit) {
        return new VisitPatientDto(
                visit.getPatient().getName(),
                visit.getPatient().isHasInsurance(),
                visit.getPatient().getUid()
        );
    }

    private List<Diagnosis> getDiagnoses(NewVisitDto dto) {
        return dto.diagnoses().stream()
                .map(diagnosis -> diagnosisService.findByCode(diagnosis.code()))
                .toList();
    }
}
