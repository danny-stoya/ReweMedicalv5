package com.example.rewemedicalv5.services;

import com.example.rewemedicalv5.data.dtos.diagnosis.EditDiagnosisDto;
import com.example.rewemedicalv5.data.dtos.diagnosis.NewDiagnosisDto;
import com.example.rewemedicalv5.data.dtos.diagnosis.ViewDiagnosisDto;
import com.example.rewemedicalv5.data.entities.Diagnosis;
import com.example.rewemedicalv5.data.repositories.DiagnosisRepository;
import com.example.rewemedicalv5.exceptions.DiagnosisNotFound;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor

public class DiagnosisService {
    private final DiagnosisRepository diagnosisRepository;

    public void create(NewDiagnosisDto dto) {
        diagnosisRepository.save(
                toEntity(dto)
        );
    }

    public List<ViewDiagnosisDto> getAll() {
        return toViewList(
                diagnosisRepository.findAll()
        );
    }

//    public ViewDiagnosisDto findById(Long id) {
//        return toView(
//                diagnosisRepository
//                .findById(id)
//                .orElseThrow(() -> new DiagnosisNotFound(id)));
//    }

    public ViewDiagnosisDto update(String code, EditDiagnosisDto dto) {
        return toView(
                diagnosisRepository.save(updateDiagnosis(code, dto))
        );
    }

//    public void delete(Long id) {
//        diagnosisRepository.deleteById(id);
//    }

    public void delete(String code) {
        diagnosisRepository.delete(
                findByCode(code)
        );
    }

    public ViewDiagnosisDto findViewByCode(String code) {
        return toView(findByCode(code));
    }

    public Diagnosis findByCode(String code) {
        return diagnosisRepository
                .findByCode(code)
                .orElseThrow(() -> new DiagnosisNotFound(code));
    }

    private List<ViewDiagnosisDto> toViewList(List<Diagnosis> diagnoses) {
        return diagnoses
                .stream()
                .map(this::toView)
                .toList();
    }

    private ViewDiagnosisDto toView(Diagnosis diagnosis) {
        return new ViewDiagnosisDto(
                diagnosis.getCode(),
                diagnosis.getDescription()
        );
    }

    private Diagnosis toEntity(NewDiagnosisDto dto) {
        return new Diagnosis(
                dto.code(),
                dto.description(),
                false
        );
    }

    private Diagnosis updateDiagnosis(String code, EditDiagnosisDto dto) {
        return findByCode(code)
                .setDescription(dto.description());
    }
}
