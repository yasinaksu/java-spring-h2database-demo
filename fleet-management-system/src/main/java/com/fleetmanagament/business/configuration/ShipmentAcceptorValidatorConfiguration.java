package com.fleetmanagament.business.configuration;

import com.fleetmanagament.business.validation.shipmentacceptor.*;
import com.fleetmanagament.business.validation.shipmentacceptor.concrete.BranchAcceptorValidatorImplementation;
import com.fleetmanagament.business.validation.shipmentacceptor.concrete.DistributionCenterAcceptorValidatorImplementation;
import com.fleetmanagament.business.validation.shipmentacceptor.concrete.ShipmentAttemptToSendWrongDeliveryPointHandlerValidatorImplementation;
import com.fleetmanagament.business.validation.shipmentacceptor.concrete.TransferCenterAcceptorValidatorImplementation;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.bind.Name;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ShipmentAcceptorValidatorConfiguration {

    @Bean
    public ShipmentAttemptToSendWrongDeliveryPointHandlerValidator getShipmentAttemptToSendWrongDeliveryPointHandlerValidatorImplementation(){
        return new ShipmentAttemptToSendWrongDeliveryPointHandlerValidatorImplementation();
    }

    @Bean
    public TransferCenterAcceptorValidator getTransferCenterAcceptorValidatorImplementation(){
        return new TransferCenterAcceptorValidatorImplementation();
    }

    @Bean
    public DistribtionCenterAcceptorValidator getDistributionCenterAcceptorValidatorImplementation(){
        return new DistributionCenterAcceptorValidatorImplementation();
    }

    @Bean
    public BranchAcceptorValidator getBranchAcceptorValidatorImplementation(){
        return new BranchAcceptorValidatorImplementation();
    }
}
