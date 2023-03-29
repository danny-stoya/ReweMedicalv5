package com.example.rewemedicalv5.exceptions.validations;

import com.example.rewemedicalv5.data.repositories.DoctorRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DoctorExistValidator implements ConstraintValidator<DoctorExist, String> {
    private final DoctorRepository doctorRepository;
    @Override
    public boolean isValid(String uid, ConstraintValidatorContext context) {
        return uid != null && doctorRepository.findByUid(uid).isPresent();
    }
}
