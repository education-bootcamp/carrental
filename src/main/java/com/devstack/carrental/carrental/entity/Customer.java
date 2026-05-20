package com.devstack.carrental.carrental.entity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "customer")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "property_id")
    private UUID id;

    @Column(name = "nic", nullable = false, length = 20)
    private String nic;

    @Column(name = "driving_license_no", nullable = false, length = 50)
    private String drivingLicenseNo;

    @Column(name = "license_expiry_date")
    private LocalDate licenseExpiryDate;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @Column(name = "notes", columnDefinition = "TEXT")
    private String notes;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_property_id", nullable = false)
    private User user;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<LicenseImage> licenseImages;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Address> addresses;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Booking> bookings;
}
