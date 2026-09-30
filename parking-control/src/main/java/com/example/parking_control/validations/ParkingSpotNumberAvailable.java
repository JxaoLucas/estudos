package com.example.parking_control.validations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Documented
@Constraint(validatedBy = ParkingSpotNumberAvailableValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ParkingSpotNumberAvailable {
    String message() default "Vaga de estacionamento já está em uso";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
