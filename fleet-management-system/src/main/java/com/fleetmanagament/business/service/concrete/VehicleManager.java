package com.fleetmanagament.business.service.concrete;

import com.fleetmanagament.business.mapper.VehicleMapper;
import com.fleetmanagament.business.service.VehicleService;
import com.fleetmanagament.dataaccess.repository.VehicleRepository;
import com.fleetmanagament.entity.domain.Vehicle;
import com.fleetmanagament.entity.dto.vehicle.CreateVehicleRequestDto;
import com.fleetmanagament.entity.dto.vehicle.CreateVehicleResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VehicleManager implements VehicleService {
    private final VehicleRepository vehicleRepository;
    private final VehicleMapper vehicleMapper;

    @Autowired
    public VehicleManager(VehicleRepository vehicleRepository, VehicleMapper vehicleMapper) {
        this.vehicleRepository = vehicleRepository;
        this.vehicleMapper = vehicleMapper;
    }

    @Override
    public CreateVehicleResponseDto createVehicle(CreateVehicleRequestDto createVehicleRequestDto) {
        Vehicle vehicleToCreate = this.vehicleMapper.toEntity(createVehicleRequestDto);
        this.vehicleRepository.save(vehicleToCreate);
        CreateVehicleResponseDto createVehicleResponseDto = this.vehicleMapper.toDto(vehicleToCreate);
        return createVehicleResponseDto;
    }

}
