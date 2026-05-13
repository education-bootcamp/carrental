package com.devstack.carrental.carrental.repository;

import com.devstack.carrental.carrental.entity.Damage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DamageRepository extends JpaRepository<Damage, Integer> {
    List<Damage> findByVehicleId(Integer vehicleId);
    List<Damage> findByIsFixed(Boolean isFixed);
    List<Damage> findByVehicleIdAndIsFixed(Integer vehicleId, Boolean isFixed);
}
