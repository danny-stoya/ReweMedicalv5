package com.example.rewemedicalv5.services;

import com.example.rewemedicalv5.data.dtos.doctor.NewDoctorDto;
import com.example.rewemedicalv5.data.dtos.doctor.EditDoctorDto;
import com.example.rewemedicalv5.data.dtos.doctor.ViewDoctorDto;
import com.example.rewemedicalv5.data.dtos.specialty.ViewSpecialtyDto;
import com.example.rewemedicalv5.data.entities.Doctor;
import com.example.rewemedicalv5.data.entities.Specialty;
import com.example.rewemedicalv5.data.repositories.DoctorRepository;
import com.example.rewemedicalv5.exceptions.DoctorNotFound;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DoctorService {
    private final DoctorRepository doctorRepository;
    private final SpecialtyService specialtyService;

    public void create(NewDoctorDto dto) {
        doctorRepository.save(toEntity(dto));
    }

    public List<ViewDoctorDto> getAll() {
        return toViewList(
                doctorRepository.findAll()
        );
    }

    public ViewDoctorDto update(String uid, EditDoctorDto dto) {
        return toView(
                doctorRepository.save(
                        updateDoctor(uid, dto)
                )
        );
    }

    public void delete(String uid) {
        doctorRepository.delete(
                findByUid(uid)
        );
    }

//    public void delete(Long id) {
//        doctorRepository.deleteById(id);
//    }

    public ViewDoctorDto findViewByUid(String uid) {
        return toView(findByUid(uid));
    }

    public Doctor findByUid(String uid) {
        return doctorRepository
                .findByUid(uid)
                .orElseThrow(() -> new DoctorNotFound(uid)
                );
    }

    private List<ViewDoctorDto> toViewList(List<Doctor> doctors) {
        return doctors
                .stream()
                .map(this::toView)
                .toList();
    }

    private ViewDoctorDto toView(Doctor doctor) {
        return new ViewDoctorDto(
                doctor.getUid(),
                doctor.getName(),
                doctor.getBirthDate(),
                doctor.isGp(),
                doctor.getSpecialties()
                        .stream()
                        .map(specialty -> new ViewSpecialtyDto(specialty.getName()))
                        .collect(Collectors.toSet())
        );
    }

    private Doctor toEntity(NewDoctorDto dto) {
        return new Doctor(
                dto.name(),
                dto.birthDate(),
                dto.uid(),
                dto.isGp(),
                mapSpecialties(dto.specialties()),
                false
        );
    }

    private Doctor updateDoctor(String uid, EditDoctorDto dto) {
        return findByUid(uid)
                .setName(dto.name())
                .setBirthDate(dto.birthDate())
                .setGp(dto.isGp())
                .setSpecialties(mapSpecialties(dto.specialties())
                );
    }

    private Set<Specialty> mapSpecialties(Set<String> specialties) {
        return specialties
                .stream()
                .map(specialtyService::findByName)
                .collect(Collectors.toSet()
                );
    }

}
