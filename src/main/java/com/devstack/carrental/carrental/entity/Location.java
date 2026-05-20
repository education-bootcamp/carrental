package com.devstack.carrental.carrental.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "location")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "property_id")
    private UUID id;

    @Column(name = "location_name", nullable = false, length = 45)
    private String locationName;

    @Column(name = "address", columnDefinition = "TEXT")
    private String address;

    @Column(name = "city", nullable = false, length = 45)
    private String city;

    @Column(name = "latitude", precision = 10, scale = 7)
    private BigDecimal latitude;

    @Column(name = "longitude", precision = 10, scale = 7)
    private BigDecimal longitude;

    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "pickupLocation", fetch = FetchType.LAZY)
    private List<Booking> pickupBookings;

    @OneToMany(mappedBy = "dropoffLocation", fetch = FetchType.LAZY)
    private List<Booking> dropoffBookings;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }
}
