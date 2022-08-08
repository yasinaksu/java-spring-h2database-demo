package com.fleetmanagament.business.mapper;

import com.fleetmanagament.entity.domain.Shipment;
import com.fleetmanagament.entity.dto.shipment.DeliveryDto;
import com.fleetmanagament.entity.dto.shipment.DistributeShipmentRequestDto;
import com.fleetmanagament.entity.dto.shipment.DistributeShipmentResponseDto;

public interface ShipmentMapper {
    DistributeShipmentResponseDto toDistributeShipmentResponseDto(DistributeShipmentRequestDto requestDto);
    void updateDeliveryDtoStateFromShipment(DeliveryDto deliveryDto, Shipment shipment);
}
