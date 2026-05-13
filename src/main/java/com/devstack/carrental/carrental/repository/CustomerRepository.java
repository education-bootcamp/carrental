package com.devstack.carrental.carrental.repository;

import com.devstack.carrental.carrental.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    Optional<Customer> findByNic(String nic);
    Optional<Customer> findByDrivingLicenseNo(String drivingLicenseNo);
    Optional<Customer> findByUserId(Integer userId);
}
