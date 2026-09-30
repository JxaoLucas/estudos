package com.example.parking_control.dtos;

import com.example.parking_control.validations.LicensePlate;
import com.example.parking_control.validations.LicensePlateNotRegistered;
import com.example.parking_control.validations.OnCreate;

import jakarta.validation.constraints.NotBlank;

public class CarroDto {

    @LicensePlate
    @LicensePlateNotRegistered(groups = OnCreate.class)
    private String licensePlate;

    @NotBlank
    private String brand;

    @NotBlank
    private String model;

    @NotBlank
    private String color;

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
