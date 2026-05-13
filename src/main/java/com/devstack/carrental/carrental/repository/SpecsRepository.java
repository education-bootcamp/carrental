package com.devstack.carrental.carrental.repository;

import com.devstack.carrental.carrental.entity.Specs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpecsRepository extends JpaRepository<Specs, Integer> {
    List<Specs> findByIsActive(Boolean isActive);
}
