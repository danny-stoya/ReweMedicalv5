package com.example.rewemedicalv5.exceptions.validations;

import com.example.rewemedicalv5.data.dtos.visit.NewVisitDto;
import com.example.rewemedicalv5.data.repositories.VisitRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@AllArgsConstructor
public class VisitAvailabilityValidator implements ConstraintValidator<VisitAvailability, NewVisitDto> {
    private final VisitRepository visitRepository;

    @Override
    public boolean isValid(NewVisitDto dto, ConstraintValidatorContext context) {
        return visitRepository
                .findByVisitTimeAndDoctor_Uid(dto.visitTime(), dto.doctorUid())
                .isEmpty();
    }
}
