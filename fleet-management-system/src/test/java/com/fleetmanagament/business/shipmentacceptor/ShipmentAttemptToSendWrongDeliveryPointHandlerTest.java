package com.fleetmanagament.business.shipmentacceptor;

import com.fleetmanagament.business.constant.Messages;
import com.fleetmanagament.business.validation.shipmentacceptor.ShipmentAttemptToSendWrongDeliveryPointHandlerValidator;
import com.fleetmanagament.entity.domain.DeliveryPoint;
import com.fleetmanagament.entity.domain.Package;
import com.fleetmanagament.entity.exception.AttemptDeliverWrongPointException;
import com.fleetmanagament.entity.exception.PackageMustHaveSameDeliveryPointAsBagException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
public class ShipmentAttemptToSendWrongDeliveryPointHandlerTest {

    @Mock
    private ShipmentAcceptor shipmentAcceptor;

    @Mock
    ShipmentAttemptToSendWrongDeliveryPointHandlerValidator shipmentAcceptorValidator;
    @InjectMocks
    private ShipmentAttemptToSendWrongDeliveryPointHandler deliveryPointHandler;

    @Test
    public void acceptDelivery_throwExceptionWhenShipmentSendWrongDeliveryPoint() {
        DeliveryPoint deliveryPoint = DeliveryPoint.create();
        deliveryPoint.setValue(1);
        Package shipment = Package.create();
        shipment.setDeliveryPoint(deliveryPoint);

        Mockito.when(
                this.shipmentAcceptorValidator.validateIsUnloadable(
                        Mockito.any(Package.class),
                        Mockito.anyInt()
                )
        ).thenReturn(false);
        String expectedMessage = Messages.ATTEMPT_TO_DELIVER_WRONG_POINT;

        Exception exception = assertThrows(AttemptDeliverWrongPointException.class, () -> {
            deliveryPointHandler.acceptDelivery(shipment,2);
        });

        Assertions.assertThat(exception.getMessage()).isEqualTo(expectedMessage);

    }

    @Test
    public void acceptDelivery_skipToNextSuccessorShipmentSendTrueDeliveryPoint() {
        Integer deliveryPointValue = 1;
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
        assertDoesNotThrow(()->{
            deliveryPointHandler.acceptDelivery(shipment,deliveryPointValue);
        });
    }
}