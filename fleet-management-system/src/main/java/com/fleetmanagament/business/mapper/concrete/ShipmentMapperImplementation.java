package com.fleetmanagament.business.mapper.concrete;

import com.fleetmanagament.business.mapper.ShipmentMapper;
import com.fleetmanagament.entity.domain.Shipment;
import com.fleetmanagament.entity.dto.shipment.DeliveryDto;
import com.fleetmanagament.entity.dto.shipment.DistributeShipmentRequestDto;
import com.fleetmanagament.entity.dto.shipment.DistributeShipmentResponseDto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ShipmentMapperImplementation implements ShipmentMapper {

    @Override
    public DistributeShipmentResponseDto toDistributeShipmentResponseDto(DistributeShipmentRequestDto requestDto) {
        String plate = requestDto.getPlate();
        DistributeShipmentResponseDto responseDto = new DistributeShipmentResponseDto();
        responseDto.setPlate(plate);
        responseDto.setRoute(requestDto.getRoute());
        return responseDto;
    }

    @Override
    public void updateDeliveryDtoStateFromShipment(DeliveryDto deliveryDto, Shipment shipment) {
        deliveryDto.setState(shipment.getState());
    }

}
