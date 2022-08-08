package com.fleetmanagament.business.service;

import com.fleetmanagament.entity.domain.Shipment;
import com.fleetmanagament.entity.dto.shipment.DistributeShipmentRequestDto;
import com.fleetmanagament.entity.dto.shipment.DistributeShipmentResponseDto;

public interface ShipmentService {
    DistributeShipmentResponseDto distributeShipment(DistributeShipmentRequestDto distributeShipmentRequestDto);
    Shipment findByBarcode(String barcode);
}
