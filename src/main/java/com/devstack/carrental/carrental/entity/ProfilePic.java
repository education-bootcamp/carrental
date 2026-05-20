package com.devstack.carrental.carrental.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "profile_pic")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProfilePic {

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

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_property_id", nullable = false)
    private User user;
}
