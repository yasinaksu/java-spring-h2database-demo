package com.fleetmanagament.business.service;

import com.fleetmanagament.entity.dto.deliverypoint.CreateDeliveryPointRequestDto;
import com.fleetmanagament.entity.dto.deliverypoint.CreateDeliveryPointResponseDto;

public interface DeliveryPointService {
    CreateDeliveryPointResponseDto createDeliveryPoint(CreateDeliveryPointRequestDto createDeliveryPointRequestDto);
}
