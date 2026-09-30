package com.example.parking_control.validations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.ReportAsSingleViolation;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@Documented
@Constraint(validatedBy = {})
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@NotBlank
@Pattern(regexp = "^[A-Z]{3}[0-9][A-Z0-9][0-9]{2}$")
@ReportAsSingleViolation
public @interface LicensePlate {
    String message() default "Placa inválida (use ABC1234 ou ABC1D23)";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}