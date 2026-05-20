package com.devstack.carrental.carrental.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "address")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "property_id")
    private UUID id;

    @Column(name = "address", columnDefinition = "TEXT")
    private String address;

    @Column(name = "city", length = 45)
    private String city;

    @Column(name = "country", length = 45)
    private String country;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_property_id", nullable = false)
    private Customer customer;
}
