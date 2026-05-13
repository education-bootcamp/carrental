package com.devstack.carrental.carrental.repository;

import com.devstack.carrental.carrental.entity.VehicleDamageImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleDamageImageRepository extends JpaRepository<VehicleDamageImage, Integer> {
    List<VehicleDamageImage> findByDamageId(Integer damageId);
}
