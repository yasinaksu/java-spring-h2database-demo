package com.fleetmanagament.business.validation.shipmentacceptor.concrete;

import com.fleetmanagament.business.validation.shipmentacceptor.ShipmentAttemptToSendWrongDeliveryPointHandlerValidator;
import com.fleetmanagament.entity.domain.Shipment;

public class ShipmentAttemptToSendWrongDeliveryPointHandlerValidatorImplementation implements ShipmentAttemptToSendWrongDeliveryPointHandlerValidator {

    @Override
    public boolean validateIsUnloadable(Shipment shipment, Integer deliveryPoint) {
        boolean isUnloadable = true;
        if (shipment.getDeliveryPoint().getValue() != deliveryPoint) {
            isUnloadable = false;
        }
        return isUnloadable;
    }
}
