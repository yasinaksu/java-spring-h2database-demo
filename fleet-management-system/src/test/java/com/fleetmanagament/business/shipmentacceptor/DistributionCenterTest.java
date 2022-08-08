package com.fleetmanagament.business.shipmentacceptor;

import com.fleetmanagament.business.validation.shipmentacceptor.DistribtionCenterAcceptorValidator;
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
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class DistributionCenterTest {
    @Mock
    private ShipmentAcceptor shipmentAcceptor;
    @Mock
    private DistribtionCenterAcceptorValidator shipmentAcceptorValidator;
    @InjectMocks
    private DistributionCenter distributionCenter;

    @Test
    public void whenShipmentTypeIsPackageNotInBag_andDeliveryPointIsTrue_thenAcceptDelivery() {
        Integer deliveryPointValue = DeliveryPointType.DISTRIBUTION_CENTER.getValue();
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
        this.distributionCenter.acceptDelivery(shipment,deliveryPointValue);

        Assertions.assertThat(shipment.getState()).isEqualTo(ShipmentState.UNLOADED.getValue());
    }

    @Test
    public void whenShipmentTypeIsPackageInBag_andDeliveryPointIsTrue_thenAcceptDelivery() {
        Integer deliveryPointValue = DeliveryPointType.DISTRIBUTION_CENTER.getValue();
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
        ).thenReturn(true);
        this.distributionCenter.acceptDelivery(shipment,deliveryPointValue);

        Assertions.assertThat(shipment.getState()).isEqualTo(ShipmentState.UNLOADED.getValue());
    }

    @Test
    public void whenShipmentTypeIsBag_andDeliveryPointIsTrue_thenAcceptDelivery() {
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
        ).thenReturn(true);
        this.distributionCenter.acceptDelivery(shipment,deliveryPointValue);

        Assertions.assertThat(shipment.getState()).isEqualTo(ShipmentState.UNLOADED.getValue());
    }

    @Test
    public void whenShipmentDeliveryDeliveryPointIsTransferCenter_thenCannotUnload() {
        Integer deliveryPointValue = DeliveryPointType.TRANSFER_CENTER.getValue();
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
        this.distributionCenter.acceptDelivery(shipment,deliveryPointValue);
        Assertions.assertThat(shipment.getState()).isNotEqualTo(ShipmentState.UNLOADED.getValue());
    }
}