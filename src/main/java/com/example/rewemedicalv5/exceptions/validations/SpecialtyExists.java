package com.example.rewemedicalv5.exceptions.validations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.PARAMETER, ElementType.TYPE_USE})
@Constraint(validatedBy = SpecialtyExistsValidator.class)
public @interface SpecialtyExists {
    String message() default "Specialty not found";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
