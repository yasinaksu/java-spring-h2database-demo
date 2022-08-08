package com.fleetmanagament.business.mapper;

import com.fleetmanagament.entity.domain.Vehicle;
import com.fleetmanagament.entity.dto.vehicle.CreateVehicleRequestDto;
import com.fleetmanagament.entity.dto.vehicle.CreateVehicleResponseDto;

public interface VehicleMapper {
    Vehicle toEntity(CreateVehicleRequestDto createVehicleRequestDto);
    CreateVehicleResponseDto toDto(Vehicle vehicle);
}
