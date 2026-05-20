package com.devstack.carrental.carrental.entity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "damage_report")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DamageReport {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "property_id")
    private UUID id;

    @Column(name = "date")
    private LocalDateTime date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "booking_property_id", nullable = false)
    private Booking booking;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "damge_property_id", nullable = false)
    private Damage damage;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reviewd_by")
    private User reviewedBy;

    @PrePersist
    protected void onCreate() {
        date = LocalDateTime.now();
    }
}
