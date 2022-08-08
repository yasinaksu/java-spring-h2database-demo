package com.fleetmanagament.business.service.concrete;

import com.fleetmanagament.business.mapper.VehicleMapper;
import com.fleetmanagament.dataaccess.repository.VehicleRepository;
import com.fleetmanagament.entity.domain.Vehicle;
import com.fleetmanagament.entity.dto.vehicle.CreateVehicleRequestDto;
import com.fleetmanagament.entity.dto.vehicle.CreateVehicleResponseDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class VehicleManagerTest {
    @Mock
    private VehicleRepository vehicleRepository;
    @Mock
    private VehicleMapper vehicleMapper;
    @InjectMocks
    private VehicleManager vehicleManager;


    @Test
    public void createVehicle() {
        CreateVehicleRequestDto createVehicleRequestDto = new CreateVehicleRequestDto();
        createVehicleRequestDto.setLicensePlate("34 TL 34");

        Vehicle vehicle = Vehicle.create();
        vehicle.setLicensePlate("34 TL 34");
        vehicle.setId(1L);

        Mockito.when(
                this.vehicleMapper.toEntity(ArgumentMatchers.any(CreateVehicleRequestDto.class))
        ).thenReturn(vehicle);

        Mockito.when(
                this.vehicleRepository.save(Mockito.any(Vehicle.class))
        ).thenReturn(vehicle);

        Mockito.when(
                this.vehicleMapper.toDto(ArgumentMatchers.any(Vehicle.class))
        ).thenReturn(
                CreateVehicleResponseDto.builder()
                        .withId(vehicle.getId())
                        .withLicensePlate(vehicle.getLicensePlate())
                        .build());

        CreateVehicleResponseDto responseDto
                = vehicleManager.createVehicle(createVehicleRequestDto);

        Assertions.assertThat(responseDto).isNotNull();
        Assertions.assertThat(responseDto.getId()).isEqualTo(vehicle.getId());
    }
}