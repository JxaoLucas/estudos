package com.example.parking_control.validations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Documented
@Constraint(validatedBy = LicensePlateNotRegisteredValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface LicensePlateNotRegistered {
    String message() default "Placa de veículo já cadastrada!";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}