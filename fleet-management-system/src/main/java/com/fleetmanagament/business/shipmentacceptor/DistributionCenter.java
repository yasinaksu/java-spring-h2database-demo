package com.fleetmanagament.business.shipmentacceptor;

import com.fleetmanagament.business.validation.shipmentacceptor.DistribtionCenterAcceptorValidator;
import com.fleetmanagament.entity.domain.Shipment;

public class DistributionCenter extends ShipmentAcceptor {
    public DistributionCenter(ShipmentAcceptor successor,
                              DistribtionCenterAcceptorValidator shipmentAcceptorValidator) {
        super( successor, shipmentAcceptorValidator);
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
