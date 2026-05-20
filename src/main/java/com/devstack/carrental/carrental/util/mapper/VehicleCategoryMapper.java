package com.devstack.carrental.carrental.util.mapper;

import com.devstack.carrental.carrental.dto.request.vehicle_category.VehicleCategoryRequestDTO;
import com.devstack.carrental.carrental.dto.response.vehicle_category.VehicleCategoryPublicResponseDto;
import com.devstack.carrental.carrental.dto.response.vehicle_category.VehicleCategoryResponseDto;
import com.devstack.carrental.carrental.entity.VehicleCategory;
import org.springframework.stereotype.Component;

@Component
public class VehicleCategoryMapper {
    public VehicleCategory toVehicleCategory(VehicleCategoryRequestDTO dto){
        if(dto==null) return null;
        return VehicleCategory.builder()
                .category(dto.getCategory())
                .description(dto.getDescription())
                .iconName(dto.getIconName())
                .build();
    }

    public VehicleCategoryPublicResponseDto toVehicleCategoryPublicResponseDto(VehicleCategory category){
        if(category==null) return null;
        return VehicleCategoryPublicResponseDto.builder()
                .id(category.getId())
                .category(category.getCategory())
                .description(category.getDescription())
                .iconName(category.getIconName())
                .vehicleCount((long) category.getVehicles().size()).build();
    }
    public VehicleCategoryResponseDto toVehicleCategoryResponseDto(VehicleCategory category){
        if(category==null) return null;
        return VehicleCategoryResponseDto.builder()
                .id(category.getId())
                .category(category.getCategory())
                .createdAt(category.getCreatedAt())
                .description(category.getDescription())
                .iconName(category.getIconName())
                .vehicleCount((long) category.getVehicles().size()).build();
    }
}
