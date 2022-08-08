package com.fleetmanagament.business.shipmentacceptor;

import com.fleetmanagament.business.validation.shipmentacceptor.ShipmentAcceptorValidator;
import com.fleetmanagament.entity.domain.Shipment;

public abstract class ShipmentAcceptor {
    private final ShipmentAcceptor successor;
    protected final ShipmentAcceptorValidator shipmentAcceptorValidator;
    public ShipmentAcceptor(ShipmentAcceptor successor,
                            ShipmentAcceptorValidator shipmentAcceptorValidator){
        this.successor= successor;
        this.shipmentAcceptorValidator = shipmentAcceptorValidator;
    }

    public abstract void acceptDelivery(Shipment shipment, Integer deliveryPoint);

    protected void acceptNext(Shipment shipment, Integer deliveryPoint) {
        if (successor != null) {
            successor.acceptDelivery(shipment, deliveryPoint);
        }
    }

}
