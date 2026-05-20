package com.devstack.carrental.carrental.repository;

import com.devstack.carrental.carrental.entity.VehicleCategory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface VehicleCategoryRepository extends JpaRepository<VehicleCategory, UUID> {
    @Query(value = "SELECT * FROM vehicle_category WHERE category LIKE %?1% OR description LIKE %?1%", nativeQuery = true)
    public Page<VehicleCategory> findAll(String searchText, Pageable pageable);
    @Query(value = "SELECT COUNT(*) FROM vehicle_category WHERE category LIKE %?1% OR description LIKE %?1%", nativeQuery = true)
    public Long findAllCount(String searchText);
}
