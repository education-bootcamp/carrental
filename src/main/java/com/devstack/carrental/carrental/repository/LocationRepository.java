package com.devstack.carrental.carrental.repository;

import com.devstack.carrental.carrental.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocationRepository extends JpaRepository<Location, Integer> {
    List<Location> findByIsActive(Boolean isActive);
    List<Location> findByCityIgnoreCase(String city);
}
