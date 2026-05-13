package com.devstack.carrental.carrental.repository;

import com.devstack.carrental.carrental.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {
    Optional<Booking> findByBookingRef(String bookingRef);
    List<Booking> findByCustomerId(Integer customerId);
    List<Booking> findByVehicleId(Integer vehicleId);
    List<Booking> findByStatus(Booking.BookingStatus status);
    List<Booking> findByCustomerIdAndStatus(Integer customerId, Booking.BookingStatus status);

    @Query("SELECT b FROM Booking b WHERE b.vehicle.id = :vehicleId " +
           "AND b.status NOT IN ('CANCELLED', 'COMPLETED', 'NO_SHOW') " +
           "AND (b.pickupDate <= :dropoff AND b.dropoffDate >= :pickup)")
    List<Booking> findConflictingBookings(
        @Param("vehicleId") Integer vehicleId,
        @Param("pickup") LocalDate pickupDate,
        @Param("dropoff") LocalDate dropoffDate
    );
}
