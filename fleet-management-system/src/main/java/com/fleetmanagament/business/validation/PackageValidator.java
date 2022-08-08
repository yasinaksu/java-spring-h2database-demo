package com.fleetmanagament.business.validation;

import com.fleetmanagament.entity.domain.Bag;
import com.fleetmanagament.entity.domain.Package;
import com.fleetmanagament.entity.exception.PackageMustHaveSameDeliveryPointAsBagException;

import java.util.Objects;

public interface PackageValidator {
    void assignPackageToBagValidation(Package packageEntity, Bag bag) throws PackageMustHaveSameDeliveryPointAsBagException;
}

