package com.devstack.carrental.carrental.repository;

import com.devstack.carrental.carrental.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {
    Optional<Vehicle> findByRegNo(String regNo);
    List<Vehicle> findByStatus(Vehicle.Status status);
    List<Vehicle> findByVehicleCategoryId(Integer categoryId);
    List<Vehicle> findByFuelType(Vehicle.FuelType fuelType);
    List<Vehicle> findByTransmission(Vehicle.Transmission transmission);
}
