package com.example.rewemedicalv5.exceptions.validations;

import com.example.rewemedicalv5.data.dtos.doctor.NewDoctorDto;
import com.example.rewemedicalv5.data.repositories.DoctorRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UniqueDoctorValidator implements ConstraintValidator<UniqueDoctor, NewDoctorDto> {
    private DoctorRepository doctorRepository;

    @Override
    public boolean isValid(NewDoctorDto dto, ConstraintValidatorContext context) {
        return doctorRepository.findByUid(dto.uid()).isEmpty();
    }
}