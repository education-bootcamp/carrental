package com.devstack.carrental.carrental.repository;

import com.devstack.carrental.carrental.entity.DamageReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DamageReportRepository extends JpaRepository<DamageReport, Integer> {
    List<DamageReport> findByBookingId(Integer bookingId);
    List<DamageReport> findByDamageId(Integer damageId);
    List<DamageReport> findByReviewedById(Integer userId);
}
