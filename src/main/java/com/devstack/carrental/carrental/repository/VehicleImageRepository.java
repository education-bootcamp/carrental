package com.devstack.carrental.carrental.repository;

import com.devstack.carrental.carrental.entity.VehicleImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface VehicleImageRepository extends JpaRepository<VehicleImage, UUID> {

}
