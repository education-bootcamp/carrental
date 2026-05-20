package com.devstack.carrental.carrental.dto.response.vehicle_category;

import jakarta.persistence.Column;
import lombok.*;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class VehicleCategoryPublicResponseDto {
    private UUID id;
    private String category;
    private String description;
    private String iconName;
    private Long vehicleCount;
}
