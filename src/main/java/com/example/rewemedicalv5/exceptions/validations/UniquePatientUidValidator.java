package com.example.rewemedicalv5.exceptions.validations;

import com.example.rewemedicalv5.data.repositories.PatientRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UniquePatientUidValidator implements ConstraintValidator<UniquePatientUid, String> {
    private PatientRepository patientRepository;

    @Override
    public boolean isValid(String uid, ConstraintValidatorContext context) {
        return patientRepository.findByUid(uid).isEmpty();
    }
}