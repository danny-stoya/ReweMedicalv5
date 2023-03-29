package com.example.rewemedicalv5.services;

import com.example.rewemedicalv5.data.dtos.specialty.EditSpecialtyDto;
import com.example.rewemedicalv5.data.dtos.specialty.NewSpecialtyDto;
import com.example.rewemedicalv5.data.dtos.specialty.ViewSpecialtyDto;
import com.example.rewemedicalv5.data.entities.Specialty;
import com.example.rewemedicalv5.data.repositories.SpecialtyRepository;
import com.example.rewemedicalv5.exceptions.SpecialtyNotFound;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SpecialtyService {
    private final SpecialtyRepository specialtyRepository;

    public void create(NewSpecialtyDto dto) {
        specialtyRepository.save(
                toEntity(dto)
        );
    }

    public List<ViewSpecialtyDto> getAll() {
        return toViewList(
                specialtyRepository.findAll()
        );
    }

//    public ViewSpecialtyDto findById(Long id) {
//        return toView(
//                specialtyRepository
//                        .findById(id)
//                        .orElseThrow(() -> new SpecialtyNotFound(id))
//        );
//    }

    public ViewSpecialtyDto update(String name, EditSpecialtyDto dto) {
        return toView(
                specialtyRepository.save(updateSpecialty(name, dto))
        );
    }

//    public void delete(Long id) {
//        specialtyRepository.deleteById(id);
//    }

    public void delete(String name) {
        specialtyRepository.delete(
                findByName(name)
        );
    }

    public ViewSpecialtyDto getViewByName(String name) {
        return toView(findByName(name));
    }

    public Specialty findByName(String name) {
        return specialtyRepository
                .findByName(name)
                .orElseThrow(() -> new SpecialtyNotFound(name));
    }

    private Specialty toEntity(NewSpecialtyDto dto) {
        return new Specialty(dto.name(),false);
    }

    private ViewSpecialtyDto toView(Specialty specialty) {
        return new ViewSpecialtyDto(
                specialty.getName()
        );
    }

    private List<ViewSpecialtyDto> toViewList(List<Specialty> specialties) {
        return specialties
                .stream()
                .map(this::toView)
                .toList();
    }

    private Specialty updateSpecialty(String name, EditSpecialtyDto dto) {
        return findByName(name)
                .setName(dto.name());
    }

//    public Specialty findDoctorSpecialty(DoctorSpecialtyDto dto) {
//        return specialtyRepository
//                .findByName(dto.name())
//                .orElseGet(() -> new Specialty(dto.name()));
//    }
}
