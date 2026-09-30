package com.example.parking_control.services;

import com.example.parking_control.repositories.CarroRepository;
import org.springframework.stereotype.Service;

@Service
public class CarroService {

    private final CarroRepository carroRepository;

    public CarroService(CarroRepository carroRepository) {
        this.carroRepository = carroRepository;
    }

    public boolean existsByLicensePlate(String licensePlate) {
        return carroRepository.existsByLicensePlate(licensePlate);
    }

}
