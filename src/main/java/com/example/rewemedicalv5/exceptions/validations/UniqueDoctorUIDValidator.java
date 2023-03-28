package com.example.rewemedicalv5.exceptions.validations;

import com.example.rewemedicalv5.data.repositories.DoctorRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UniqueDoctorUIDValidator implements ConstraintValidator<UniqueDoctorUID, String> {
    private DoctorRepository doctorRepository;

    @Override
    public boolean isValid(String uid, ConstraintValidatorContext context) {
        return doctorRepository.findByUid(uid).isEmpty();
    }
}