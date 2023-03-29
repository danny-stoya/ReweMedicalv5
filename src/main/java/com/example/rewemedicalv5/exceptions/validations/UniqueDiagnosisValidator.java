package com.example.rewemedicalv5.exceptions.validations;

import com.example.rewemedicalv5.data.dtos.diagnosis.NewDiagnosisDto;
import com.example.rewemedicalv5.data.repositories.DiagnosisRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UniqueDiagnosisValidator implements ConstraintValidator<UniqueDiagnosis, NewDiagnosisDto> {
    private DiagnosisRepository diagnosisRepository;

    @Override
    public boolean isValid(NewDiagnosisDto value, ConstraintValidatorContext context) {
        return diagnosisRepository.findByCode(value.code()).isEmpty();
    }
}