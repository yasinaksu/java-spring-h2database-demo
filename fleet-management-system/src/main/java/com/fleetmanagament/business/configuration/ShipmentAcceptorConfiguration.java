package com.fleetmanagament.business.configuration;

import com.fleetmanagament.business.shipmentacceptor.*;
import com.fleetmanagament.business.validation.shipmentacceptor.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ShipmentAcceptorConfiguration {
    @Bean
    public ShipmentAcceptor getShipmentAcceptor(BranchAcceptorValidator branchAcceptorValidator,
                                                DistribtionCenterAcceptorValidator distribtionCenterAcceptorValidator,
                                                TransferCenterAcceptorValidator transferCenterAcceptorValidator,
                                                ShipmentAttemptToSendWrongDeliveryPointHandlerValidator shipmentAttemptToSendWrongDeliveryPointHandlerValidator) {
        ShipmentAcceptor transferCenter = new TransferCenter(null,
                transferCenterAcceptorValidator);
        ShipmentAcceptor distributionCenter = new DistributionCenter(transferCenter,
                distribtionCenterAcceptorValidator);
        ShipmentAcceptor branch = new Branch(distributionCenter,
                branchAcceptorValidator);
        return new ShipmentAttemptToSendWrongDeliveryPointHandler(branch,
                shipmentAttemptToSendWrongDeliveryPointHandlerValidator);
    }
}
