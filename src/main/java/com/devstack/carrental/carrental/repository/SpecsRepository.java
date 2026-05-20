package com.devstack.carrental.carrental.repository;

import com.devstack.carrental.carrental.entity.Specs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface SpecsRepository extends JpaRepository<Specs, UUID> {

}
