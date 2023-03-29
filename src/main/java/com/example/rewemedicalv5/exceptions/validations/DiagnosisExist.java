package com.example.rewemedicalv5.exceptions.validations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Constraint(validatedBy = DiagnosisExistValidator.class)
public @interface DiagnosisExist {
    String message() default "Diagnosis not found";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
