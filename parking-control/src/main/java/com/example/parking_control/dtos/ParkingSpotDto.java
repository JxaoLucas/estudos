package com.example.parking_control.dtos;

import com.example.parking_control.validations.ApartmentBlockAvailable;
import com.example.parking_control.validations.OnCreate;
import com.example.parking_control.validations.ParkingSpotNumberAvailable;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@ApartmentBlockAvailable(groups = OnCreate.class)
public class ParkingSpotDto {

    @NotBlank
    @ParkingSpotNumberAvailable(groups = OnCreate.class)
    private String parkingSpotNumber;

    @NotBlank
    private String responsibleName;

    @NotBlank
    private String apartment;

    @NotBlank
    private String block;

    @Valid
    @NotNull
    private CarroDto carro;

    public CarroDto getCarro() {
        return carro;
    }

    public void setCarro(CarroDto carro) {
        this.carro = carro;
    }

    public String getParkingSpotNumber() {
        return parkingSpotNumber;
    }

    public void setParkingSpotNumber(String parkingSpotNumber) {
        this.parkingSpotNumber = parkingSpotNumber;
    }

    public String getResponsibleName() {
        return responsibleName;
    }

    public void setResponsibleName(String responsibleName) {
        this.responsibleName = responsibleName;
    }

    public String getApartment() {
        return apartment;
    }

    public void setApartment(String apartment) {
        this.apartment = apartment;
    }

    public String getBlock() {
        return block;
    }

    public void setBlock(String block) {
        this.block = block;
    }

}
