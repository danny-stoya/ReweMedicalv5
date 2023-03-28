package com.example.rewemedicalv5.exceptions.validations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = UniqueDiagnosisCodeValidator.class)
public @interface UniqueDiagnosisCode {
    String message() default "Diagnosis already exist";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
