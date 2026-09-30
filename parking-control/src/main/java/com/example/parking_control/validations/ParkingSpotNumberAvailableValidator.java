package com.example.parking_control.validations;

import com.example.parking_control.services.ParkingSpotService;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ParkingSpotNumberAvailableValidator
        implements ConstraintValidator<ParkingSpotNumberAvailable, String> {

    private final ParkingSpotService parkingSpotService;

    public ParkingSpotNumberAvailableValidator(ParkingSpotService parkingSpotService) {
        this.parkingSpotService = parkingSpotService;
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null || value.isBlank()) {
            return true;
        }
        return !parkingSpotService.existsByParkingSpotNumber(value);
    }
}