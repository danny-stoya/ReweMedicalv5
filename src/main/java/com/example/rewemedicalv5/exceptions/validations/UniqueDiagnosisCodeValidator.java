package com.example.rewemedicalv5.exceptions.validations;

import com.example.rewemedicalv5.data.repositories.DiagnosisRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UniqueDiagnosisCodeValidator implements ConstraintValidator<UniqueDiagnosisCode, String> {
    private DiagnosisRepository diagnosisRepository;

    @Override
    public boolean isValid(String code, ConstraintValidatorContext context) {
        return diagnosisRepository.findByCode(code).isEmpty();
    }
}