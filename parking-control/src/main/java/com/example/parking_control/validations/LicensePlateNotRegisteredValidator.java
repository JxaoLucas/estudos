package com.example.parking_control.validations;

import com.example.parking_control.services.CarroService;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class LicensePlateNotRegisteredValidator
        implements ConstraintValidator<LicensePlateNotRegistered, String> {

    private final CarroService carroService;

    public LicensePlateNotRegisteredValidator(CarroService carroService) {
        this.carroService = carroService;
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null || value.isBlank()) {
            return true;
        }
        return !carroService.existsByLicensePlate(value);
    }
}
