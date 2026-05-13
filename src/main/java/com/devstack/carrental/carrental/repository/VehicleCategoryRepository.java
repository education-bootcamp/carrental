package com.devstack.carrental.carrental.repository;

import com.devstack.carrental.carrental.entity.VehicleCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VehicleCategoryRepository extends JpaRepository<VehicleCategory, Integer> {
    Optional<VehicleCategory> findByCategoryIgnoreCase(String category);
}
