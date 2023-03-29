package com.example.rewemedicalv5.exceptions.validations;

import com.example.rewemedicalv5.data.repositories.SpecialtyRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class SpecialtyExistsValidator implements ConstraintValidator<SpecialtyExists, String> {
    private SpecialtyRepository specialtyRepository;

    @Override
    public boolean isValid(String name, ConstraintValidatorContext context) {
        return name != null && specialtyRepository.findByName(name).isPresent();
    }
}