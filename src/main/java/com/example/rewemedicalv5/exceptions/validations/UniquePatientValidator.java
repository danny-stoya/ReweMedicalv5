package com.example.rewemedicalv5.exceptions.validations;

import com.example.rewemedicalv5.data.dtos.patient.NewPatientDto;
import com.example.rewemedicalv5.data.repositories.PatientRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UniquePatientValidator implements ConstraintValidator<UniquePatient, NewPatientDto> {
    private PatientRepository patientRepository;

    @Override
    public boolean isValid(NewPatientDto dto, ConstraintValidatorContext context) {
        return patientRepository.findByUid(dto.uid()).isEmpty();
    }
}