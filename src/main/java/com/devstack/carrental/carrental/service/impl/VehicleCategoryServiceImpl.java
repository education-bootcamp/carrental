package com.devstack.carrental.carrental.service.impl;

import com.devstack.carrental.carrental.dto.request.vehicle_category.VehicleCategoryRequestDTO;
import com.devstack.carrental.carrental.dto.response.PaginatedResponseDTO;
import com.devstack.carrental.carrental.dto.response.vehicle_category.VehicleCategoryPublicResponseDto;
import com.devstack.carrental.carrental.dto.response.vehicle_category.VehicleCategoryResponseDto;
import com.devstack.carrental.carrental.entity.VehicleCategory;
import com.devstack.carrental.carrental.exception.EntryNotFoundException;
import com.devstack.carrental.carrental.repository.VehicleCategoryRepository;
import com.devstack.carrental.carrental.service.VehicleCategoryService;
import com.devstack.carrental.carrental.util.mapper.VehicleCategoryMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
@RequiredArgsConstructor
public class VehicleCategoryServiceImpl implements VehicleCategoryService {

    private final VehicleCategoryRepository vehicleCategoryRepository;
    private final VehicleCategoryMapper vehicleCategoryMapper;

    @Override
    public PaginatedResponseDTO search(String searchText, int page, int size) {
        return PaginatedResponseDTO.<VehicleCategoryPublicResponseDto>builder()
                .count(
                        vehicleCategoryRepository.findAllCount(searchText)
                )
                .dataList(
                        vehicleCategoryRepository.findAll(searchText, PageRequest.of(page, size))
                                .stream().map(vehicleCategoryMapper::toVehicleCategoryPublicResponseDto).toList()
                )
                .build();
    }

    @Override
    public PaginatedResponseDTO findAllForAdmin(String searchText, int page, int size) {
        return PaginatedResponseDTO.<VehicleCategoryResponseDto>builder()
                .count(
                        vehicleCategoryRepository.findAllCount(searchText)
                )
                .dataList(
                        vehicleCategoryRepository.findAll(searchText, PageRequest.of(page, size))
                                .stream().map(vehicleCategoryMapper::toVehicleCategoryResponseDto).toList()
                )
                .build();
    }

    @Override
    public void create(VehicleCategoryRequestDTO dto) {
        vehicleCategoryRepository.save(vehicleCategoryMapper.toVehicleCategory(dto));
    }

    @Override
    public void deleteById(UUID id) {
        vehicleCategoryRepository.deleteById(id);
    }

    @Override
    public void update(UUID id, VehicleCategoryRequestDTO dto) {
        VehicleCategory category =
                vehicleCategoryRepository.findById(id).orElseThrow(() -> new EntryNotFoundException("Category not found"));
        category.setCategory(dto.getCategory());
        category.setDescription(dto.getDescription());
        category.setIconName(dto.getIconName());
        vehicleCategoryRepository.save(category);
    }
}
