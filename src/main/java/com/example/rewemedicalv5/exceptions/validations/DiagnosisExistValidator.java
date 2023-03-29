package com.example.rewemedicalv5.exceptions.validations;

import com.example.rewemedicalv5.data.repositories.DiagnosisRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DiagnosisExistValidator implements ConstraintValidator<DiagnosisExist, String> {
    private DiagnosisRepository diagnosisRepository;

    @Override
    public boolean isValid(String code, ConstraintValidatorContext context) {
        return code != null && diagnosisRepository.findByCode(code).isPresent();
    }
}