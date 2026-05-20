package com.devstack.carrental.carrental.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "vehicle_image")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VehicleImage {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "property_id")
    private UUID id;

    @Lob
    @Column(name = "file_name", nullable = false)
    private byte[] fileName;

    @Lob
    @Column(name = "directory", nullable = false)
    private byte[] directory;

    @Lob
    @Column(name = "resource_url", nullable = false)
    private byte[] resourceUrl;

    @Lob
    @Column(name = "hash", nullable = false)
    private byte[] hash;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vehicle_property_id", nullable = false)
    private Vehicle vehicle;
}
