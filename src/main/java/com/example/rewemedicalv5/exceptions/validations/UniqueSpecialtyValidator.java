package com.example.rewemedicalv5.exceptions.validations;

import com.example.rewemedicalv5.data.dtos.specialty.NewSpecialtyDto;
import com.example.rewemedicalv5.data.repositories.SpecialtyRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UniqueSpecialtyValidator implements ConstraintValidator<UniqueSpecialty, NewSpecialtyDto> {
    private SpecialtyRepository specialtyRepository;

    @Override
    public boolean isValid(NewSpecialtyDto dto, ConstraintValidatorContext context) {
        return specialtyRepository.findByName(dto.name()).isEmpty();
    }
}