package com.fleetmanagament.business.validation.shipmentacceptor;

import com.fleetmanagament.entity.domain.Shipment;

public interface ShipmentAcceptorValidator {
    boolean validateIsUnloadable(Shipment shipment, Integer deliveryPoint);
}

