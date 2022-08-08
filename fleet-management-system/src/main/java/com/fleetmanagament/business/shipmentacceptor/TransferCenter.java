package com.fleetmanagament.business.shipmentacceptor;

import com.fleetmanagament.business.validation.shipmentacceptor.TransferCenterAcceptorValidator;
import com.fleetmanagament.entity.domain.Shipment;


public class TransferCenter extends ShipmentAcceptor {
    public TransferCenter(ShipmentAcceptor successor, TransferCenterAcceptorValidator shipmentAcceptorValidator) {
        super(successor, shipmentAcceptorValidator);
    }

    @Override
    public void acceptDelivery(Shipment shipment, Integer deliveryPoint) {
        boolean isUnloadable = this.shipmentAcceptorValidator.validateIsUnloadable(shipment,deliveryPoint);
        if (isUnloadable) {
            shipment.unload(deliveryPoint);
        } else {
            this.acceptNext(shipment,deliveryPoint);
        }
    }
}
