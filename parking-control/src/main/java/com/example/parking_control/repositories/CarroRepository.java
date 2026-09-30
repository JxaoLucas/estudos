package com.example.parking_control.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.parking_control.models.CarroModel;

@Repository
public interface CarroRepository extends JpaRepository<CarroModel, UUID> {
    boolean existsByLicensePlate(String licensePlate);

}
