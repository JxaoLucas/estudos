package com.example.parking_control.validations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Documented
@Constraint(validatedBy = ApartmentBlockAvailableValidator.class)
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface ApartmentBlockAvailable {
    String message() default "Vaga já cadastrada para esse apartamento/bloco";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
