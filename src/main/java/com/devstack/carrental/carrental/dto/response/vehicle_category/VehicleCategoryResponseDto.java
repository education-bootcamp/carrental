package com.devstack.carrental.carrental.dto.response.vehicle_category;

import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class VehicleCategoryResponseDto {
    private UUID id;
    private String category;
    private String description;
    private String iconName;
    private LocalDateTime createdAt;
    private Long vehicleCount;
}
