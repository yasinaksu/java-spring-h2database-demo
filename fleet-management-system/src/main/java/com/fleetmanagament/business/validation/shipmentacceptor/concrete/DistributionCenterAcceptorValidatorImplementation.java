package com.fleetmanagament.business.validation.shipmentacceptor.concrete;

import com.fleetmanagament.business.validation.shipmentacceptor.DistribtionCenterAcceptorValidator;
import com.fleetmanagament.entity.domain.Shipment;
import com.fleetmanagament.entity.enumtype.DeliveryPointType;

public class DistributionCenterAcceptorValidatorImplementation implements DistribtionCenterAcceptorValidator {
    private final DeliveryPointType deliveryPointType = DeliveryPointType.DISTRIBUTION_CENTER;

    @Override
    public boolean validateIsUnloadable(Shipment shipment, Integer deliveryPoint) {
        boolean isUnloadable = true;
        if (this.deliveryPointType.getValue() != deliveryPoint) {
            isUnloadable = false;
        }
        return isUnloadable;
    }
}

