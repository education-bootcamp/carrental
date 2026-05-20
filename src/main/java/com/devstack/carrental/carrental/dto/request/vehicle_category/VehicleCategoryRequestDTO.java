package com.devstack.carrental.carrental.dto.request.vehicle_category;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class VehicleCategoryRequestDTO {
    @NotBlank(message = "Category is required")
    @Size(max = 45, message = "Category cannot exceed 45 characters")
    private String category;

    @NotBlank(message = "Description is required")
    @Size(max = 1000, message = "Description cannot exceed 1000 characters")
    private String description;

    @NotBlank(message = "Icon name is required")
    @Size(max = 45, message = "Icon name cannot exceed 45 characters")
    private String iconName;
}
