package com.fleetmanagament.business.mapper.concrete;

import com.fleetmanagament.business.mapper.VehicleMapper;
import com.fleetmanagament.entity.domain.Vehicle;
import com.fleetmanagament.entity.dto.vehicle.CreateVehicleRequestDto;
import com.fleetmanagament.entity.dto.vehicle.CreateVehicleResponseDto;
import org.springframework.stereotype.Component;

@Component
public class VehicleMapperImplementation implements VehicleMapper {
    @Override
    public Vehicle toEntity(CreateVehicleRequestDto createVehicleRequestDto) {
        Vehicle vehicle = Vehicle.create()
                .setLicensePlate(createVehicleRequestDto.getLicensePlate());
        return vehicle;
    }

    @Override
    public CreateVehicleResponseDto toDto(Vehicle vehicle) {
        return CreateVehicleResponseDto.builder()
                .withId(vehicle.getId())
                .withLicensePlate(vehicle.getLicensePlate())
                .build();
    }
}
