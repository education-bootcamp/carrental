package com.devstack.carrental.carrental.repository;

import com.devstack.carrental.carrental.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {
    Optional<Payment> findByPaymentRef(String paymentRef);
    List<Payment> findByBookingId(Integer bookingId);
    List<Payment> findByStatus(Payment.PaymentStatus status);
    List<Payment> findByBookingIdAndPaymentType(Integer bookingId, Payment.PaymentType paymentType);
}
