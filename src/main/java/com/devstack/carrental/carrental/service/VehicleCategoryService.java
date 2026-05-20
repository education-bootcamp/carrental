package com.devstack.carrental.carrental.service;

import com.devstack.carrental.carrental.dto.request.vehicle_category.VehicleCategoryRequestDTO;
import com.devstack.carrental.carrental.dto.response.PaginatedResponseDTO;

import java.util.UUID;

public interface VehicleCategoryService {
    public PaginatedResponseDTO search(String searchText, int page, int size);
    public PaginatedResponseDTO findAllForAdmin(String searchText, int page, int size);
    public void create(VehicleCategoryRequestDTO dto);
    public void deleteById(UUID id);
    public void update(UUID id, VehicleCategoryRequestDTO dto);
}
