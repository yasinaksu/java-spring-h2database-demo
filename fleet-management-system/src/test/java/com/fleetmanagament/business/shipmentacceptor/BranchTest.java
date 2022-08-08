package com.fleetmanagament.business.shipmentacceptor;

import com.fleetmanagament.business.validation.shipmentacceptor.BranchAcceptorValidator;
import com.fleetmanagament.entity.domain.Bag;
import com.fleetmanagament.entity.domain.DeliveryPoint;
import com.fleetmanagament.entity.domain.Package;
import com.fleetmanagament.entity.enumtype.DeliveryPointType;
import com.fleetmanagament.entity.enumtype.ShipmentState;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class BranchTest {

    @Mock
    private ShipmentAcceptor shipmentAcceptor;
    @Mock
    private BranchAcceptorValidator shipmentAcceptorValidator;
    @InjectMocks
    private Branch branch;

    @Test
    public void whenShipmentTypeIsPackage_andPackageNotInBag_andPackageDeliveryPointIsBranch_thenAcceptDeliveryAndUnloadShipment() {
        Integer deliveryPointValue = DeliveryPointType.BRANCH.getValue();
        DeliveryPoint deliveryPoint = DeliveryPoint.create();
        deliveryPoint.setValue(deliveryPointValue);
        Package shipment = Package.create();
        shipment.setDeliveryPoint(deliveryPoint);
        Mockito.when(
                this.shipmentAcceptorValidator.validateIsUnloadable(
                        Mockito.any(Package.class),
                        Mockito.anyInt()
                )
        ).thenReturn(true);
        this.branch.acceptDelivery(shipment,deliveryPointValue);

        Assertions.assertThat(shipment.getState()).isEqualTo(ShipmentState.UNLOADED.getValue());
    }

    @Test
    public void whenShipmentTypeIsPackage_andPackageInBag_andPackageDeliveryPointIsBranch_thenCannotUnloadShipment() {
        Integer deliveryPointValue = DeliveryPointType.BRANCH.getValue();
        DeliveryPoint deliveryPoint = DeliveryPoint.create();
        deliveryPoint.setValue(deliveryPointValue);
        Package shipment = Package.create();
        shipment.setDeliveryPoint(deliveryPoint);
        shipment.loadIntoBag(Bag.create());
        Mockito.when(
                this.shipmentAcceptorValidator.validateIsUnloadable(
                        Mockito.any(Package.class),
                        Mockito.anyInt()
                )
        ).thenReturn(false);
        this.branch.acceptDelivery(shipment,deliveryPointValue);

        Assertions.assertThat(shipment.getState()).isNotEqualTo(ShipmentState.UNLOADED.getValue());
    }

    @Test
    public void whenShipmentTypeIsBag_andPackageDeliveryPointIsBranch_thenCannotUnloadShipment() {
        Integer deliveryPointValue = DeliveryPointType.BRANCH.getValue();
        DeliveryPoint deliveryPoint = DeliveryPoint.create();
        deliveryPoint.setValue(deliveryPointValue);
        Bag shipment = Bag.create();
        shipment.setDeliveryPoint(deliveryPoint);
        Mockito.when(
                this.shipmentAcceptorValidator.validateIsUnloadable(
                        Mockito.any(Bag.class),
                        Mockito.anyInt()
                )
        ).thenReturn(false);
        this.branch.acceptDelivery(shipment,deliveryPointValue);

        Assertions.assertThat(shipment.getState()).isNotEqualTo(ShipmentState.UNLOADED.getValue());
    }

    @Test
    public void whenShipmentTargetDeliveryPointIsDifferent_thenCannotUnloadShipment() {
        Integer deliveryPointValue = DeliveryPointType.DISTRIBUTION_CENTER.getValue();
        DeliveryPoint deliveryPoint = DeliveryPoint.create();
        deliveryPoint.setValue(deliveryPointValue);
        Bag shipment = Bag.create();
        shipment.setDeliveryPoint(deliveryPoint);
        Mockito.when(
                this.shipmentAcceptorValidator.validateIsUnloadable(
                        Mockito.any(Bag.class),
                        Mockito.anyInt()
                )
        ).thenReturn(false);
        this.branch.acceptDelivery(shipment,deliveryPointValue);

        Assertions.assertThat(shipment.getState()).isNotEqualTo(ShipmentState.UNLOADED.getValue());
    }
}