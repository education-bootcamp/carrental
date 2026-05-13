package com.devstack.carrental.carrental.repository;

import com.devstack.carrental.carrental.entity.LicenseImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LicenseImageRepository extends JpaRepository<LicenseImage, Integer> {
    List<LicenseImage> findByCustomerId(Integer customerId);
}
