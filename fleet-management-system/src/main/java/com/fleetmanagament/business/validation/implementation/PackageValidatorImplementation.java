package com.fleetmanagament.business.validation.implementation;

import com.fleetmanagament.business.constant.Messages;
import com.fleetmanagament.business.validation.PackageValidator;
import com.fleetmanagament.entity.domain.Bag;
import com.fleetmanagament.entity.domain.Package;
import com.fleetmanagament.entity.exception.PackageMustHaveSameDeliveryPointAsBagException;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class PackageValidatorImplementation implements PackageValidator {

    @Override
    public void assignPackageToBagValidation(Package packageEntity, Bag bag) throws PackageMustHaveSameDeliveryPointAsBagException {
        if (Objects.equals(packageEntity.getDeliveryPoint().getValue(), bag.getDeliveryPoint().getValue())) {
            packageEntity.loadIntoBag(bag);
        } else {
            throw new PackageMustHaveSameDeliveryPointAsBagException(Messages.LOADED_INTO_BAG_EXCEPTION_MESSAGE);
        }
    }
}
