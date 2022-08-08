package com.fleetmanagament.business.validation.implementation;

import com.fleetmanagament.business.constant.Messages;
import com.fleetmanagament.entity.domain.Bag;
import com.fleetmanagament.entity.domain.DeliveryPoint;
import com.fleetmanagament.entity.domain.Package;
import com.fleetmanagament.entity.exception.PackageMustHaveSameDeliveryPointAsBagException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class PackageValidatorImplementationTest {

    @InjectMocks
    private PackageValidatorImplementation packageValidator;

    @Test
    public void whenBagAndPackageHasDifferentDeliveryPoint_thenExceptionThrown(){

        DeliveryPoint packageDeliveryPoint = DeliveryPoint.create();
        packageDeliveryPoint.setValue(2);
        Package packageEntity = Package.create();
        packageEntity.setDeliveryPoint(packageDeliveryPoint);

        DeliveryPoint bagDeliveryPoint = DeliveryPoint.create();
        packageDeliveryPoint.setValue(1);
        Bag bag = Bag.create();
        bag.setDeliveryPoint(bagDeliveryPoint);

        String expectedMessage = Messages.LOADED_INTO_BAG_EXCEPTION_MESSAGE;

        Exception exception = assertThrows(PackageMustHaveSameDeliveryPointAsBagException.class, () -> {
            this.packageValidator.assignPackageToBagValidation(packageEntity,bag);
        });

        assertTrue(exception.getMessage().contains(expectedMessage));
    }
    @Test
    public void whenBagAndPackageHasSameAsDeliveryPoint_thenPackageAssignedToBag(){

        DeliveryPoint deliveryPoint = DeliveryPoint.create();
        deliveryPoint.setValue(1);

        Package packageEntity = Package.create();
        packageEntity.setDeliveryPoint(deliveryPoint);

        Bag bag = Bag.create();
        bag.setDeliveryPoint(deliveryPoint);

        assertDoesNotThrow(()->{
            this.packageValidator.assignPackageToBagValidation(packageEntity,bag);
        });

        Assertions.assertThat(packageEntity.getBag())
                .isNotNull()
                .isEqualTo(bag);
    }
}