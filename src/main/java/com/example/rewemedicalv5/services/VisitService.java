package com.example.rewemedicalv5.services;

import com.example.rewemedicalv5.data.dtos.doctor.EditDoctorDto;
import com.example.rewemedicalv5.data.dtos.doctor.ViewDoctorDto;
import com.example.rewemedicalv5.data.dtos.visit.*;
import com.example.rewemedicalv5.data.entities.Patient;
import com.example.rewemedicalv5.data.entities.Visit;
import com.example.rewemedicalv5.data.repositories.VisitRepository;
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

    public void create(NewVisitDto dto) {
        visitRepository.save(toEntity(dto));
    }

    private Visit toEntity(NewVisitDto dto) {
        Patient patient = patientService.findByUid(dto.patientUid());
        return new Visit(
          dto.dateTime(),
                patient,
                doctorService.findByUid(dto.doctorUid()),


        );
    }

    public List<ViewVisitDto> getAll() {
        return toViewList(
                visitRepository.findAll()
        );
    }

//    public ViewDoctorDto findById(Long id) {
//        return toView(
//                doctorRepository
//                        .findById(id)
//                        .orElseThrow(() -> new DoctorNotFound(id))
//        );
//    }

// DoctorNotFound   public ViewVisitDto update(String uid, EditDoctorDto dto) {
//        return toView(
//                doctorRepository.save(
//                        updateDoctor(uid, dto)
//                )
//        );
//    }

//    public void delete(Long id) {
//        doctorRepository.deleteById(id);
//    }

//    public void delete(String uid) {
//        doctorRepository.delete(
//                findByUid(uid)
//        );
//    }

//    public ViewDoctorDto findViewByUid(String uid) {
//        return toView(findByUid(uid));
//    }



}
