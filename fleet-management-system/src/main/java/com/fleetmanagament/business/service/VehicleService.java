package com.fleetmanagament.business.service;

import com.fleetmanagament.entity.dto.vehicle.CreateVehicleRequestDto;
import com.fleetmanagament.entity.dto.vehicle.CreateVehicleResponseDto;

public interface VehicleService {
    CreateVehicleResponseDto createVehicle(CreateVehicleRequestDto createVehicleRequestDto);
}
