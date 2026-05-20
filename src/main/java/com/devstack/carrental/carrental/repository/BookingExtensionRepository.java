package com.devstack.carrental.carrental.repository;

import com.devstack.carrental.carrental.entity.BookingExtension;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface BookingExtensionRepository extends JpaRepository<BookingExtension, UUID> {

}
