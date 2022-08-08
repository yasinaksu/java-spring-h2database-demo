package com.fleetmanagament.business.mapper;

import com.fleetmanagament.entity.domain.DeliveryPoint;
import com.fleetmanagament.entity.dto.deliverypoint.CreateDeliveryPointRequestDto;
import com.fleetmanagament.entity.dto.deliverypoint.CreateDeliveryPointResponseDto;

public interface DeliveryPointMapper {
    DeliveryPoint toEntity(CreateDeliveryPointRequestDto createDeliveryPointRequestDto);
    CreateDeliveryPointResponseDto toDto(DeliveryPoint deliveryPoint);
}
