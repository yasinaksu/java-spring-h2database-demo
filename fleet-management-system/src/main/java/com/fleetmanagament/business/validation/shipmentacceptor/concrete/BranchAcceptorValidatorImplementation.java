package com.fleetmanagament.business.validation.shipmentacceptor.concrete;

import com.fleetmanagament.business.validation.shipmentacceptor.BranchAcceptorValidator;
import com.fleetmanagament.entity.domain.Bag;
import com.fleetmanagament.entity.domain.Package;
import com.fleetmanagament.entity.domain.Shipment;
import com.fleetmanagament.entity.enumtype.DeliveryPointType;

public class BranchAcceptorValidatorImplementation implements BranchAcceptorValidator {
    private final DeliveryPointType deliveryPointType = DeliveryPointType.BRANCH;

    @Override
    public boolean validateIsUnloadable(Shipment shipment, Integer deliveryPoint) {
        boolean isUnloadable = true;
        if (this.deliveryPointType.getValue() != deliveryPoint) {
            isUnloadable = false;
        }
        if (shipment instanceof Bag) {
            isUnloadable = false;
        }
        if (shipment instanceof Package) {
            Package packageEntity = (Package) shipment;
            if (packageEntity.getBag() != null) {
                isUnloadable = false;
            }
        }
        return isUnloadable;
    }
}

