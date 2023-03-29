package com.example.rewemedicalv5.exceptions.validations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Constraint(validatedBy = VisitAvailabilityValidator.class)
public @interface VisitAvailability {
    String message() default "Visit already taken. Please select different time";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
