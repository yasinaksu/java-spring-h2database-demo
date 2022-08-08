package com.fleetmanagament.business.shipmentacceptor;

import com.fleetmanagament.business.constant.Messages;
import com.fleetmanagament.business.validation.shipmentacceptor.ShipmentAttemptToSendWrongDeliveryPointHandlerValidator;
import com.fleetmanagament.entity.domain.Shipment;
import com.fleetmanagament.entity.exception.AttemptDeliverWrongPointException;

public class ShipmentAttemptToSendWrongDeliveryPointHandler extends ShipmentAcceptor {

    public ShipmentAttemptToSendWrongDeliveryPointHandler(ShipmentAcceptor successor,
                                                          ShipmentAttemptToSendWrongDeliveryPointHandlerValidator shipmentAcceptorValidator) {
        super(successor, shipmentAcceptorValidator);
    }

    @Override
    public void acceptDelivery(Shipment shipment, Integer deliveryPoint) {
        boolean isUnloadable = this.shipmentAcceptorValidator.validateIsUnloadable(shipment, deliveryPoint);
        if (!isUnloadable) {
            throw new AttemptDeliverWrongPointException(Messages.ATTEMPT_TO_DELIVER_WRONG_POINT);
        } else {
            this.acceptNext(shipment, deliveryPoint);
        }
    }
}
