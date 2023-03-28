package com.example.rewemedicalv5.exceptions.validations;

import com.example.rewemedicalv5.data.repositories.SpecialtyRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UniqueSpecialtyNameValidator implements ConstraintValidator<UniqueSpecialtyName, String> {
    private SpecialtyRepository specialtyRepository;

    @Override
    public boolean isValid(String name, ConstraintValidatorContext context) {
        return specialtyRepository.findByName(name).isEmpty();
    }
}