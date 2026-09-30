package com.example.parking_control.services;

import com.example.parking_control.models.ParkingSpotModel;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ParkingSpotService {
    ParkingSpotModel save(ParkingSpotModel parkingSpotModel);

    boolean existsByParkingSpotNumber(String parkingSpotNumber);

    boolean existsByApartmentAndBlock(String apartment, String block);

    Page<ParkingSpotModel> findAll(Pageable pageable);

    Optional<ParkingSpotModel> findById(UUID id);

    void delete(ParkingSpotModel parkingSpotModel);
}
