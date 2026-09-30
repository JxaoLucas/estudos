package com.example.parking_control.validations;

import com.example.parking_control.dtos.ParkingSpotDto;
import com.example.parking_control.services.ParkingSpotService;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ApartmentBlockAvailableValidator
        implements ConstraintValidator<ApartmentBlockAvailable, ParkingSpotDto> {

    private final ParkingSpotService parkingSpotService;

    public ApartmentBlockAvailableValidator(ParkingSpotService parkingSpotService) {
        this.parkingSpotService = parkingSpotService;
    }

    @Override
    public boolean isValid(ParkingSpotDto dto, ConstraintValidatorContext context) {
        if (dto.getApartment() == null || dto.getBlock() == null) {
            return true;
        }
        boolean exists = parkingSpotService.existsByApartmentAndBlock(dto.getApartment(), dto.getBlock());
        if (exists) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(
                    "Vaga já cadastrada para esse apartamento/bloco")
                    .addPropertyNode("apartment")
                    .addConstraintViolation();
        }
        return !exists;
    }
}