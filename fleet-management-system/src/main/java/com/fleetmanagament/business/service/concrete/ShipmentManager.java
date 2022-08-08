package com.fleetmanagament.business.service.concrete;

import com.fleetmanagament.business.mapper.ShipmentMapper;
import com.fleetmanagament.business.service.ShipmentService;
import com.fleetmanagament.business.shipmentacceptor.ShipmentAcceptor;
import com.fleetmanagament.dataaccess.repository.ShipmentRepository;
import com.fleetmanagament.entity.domain.Shipment;
import com.fleetmanagament.entity.dto.shipment.DeliveryDto;
import com.fleetmanagament.entity.dto.shipment.DistributeShipmentRequestDto;
import com.fleetmanagament.entity.dto.shipment.DistributeShipmentResponseDto;
import com.fleetmanagament.entity.dto.shipment.RouteDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ShipmentManager implements ShipmentService {
    private final ShipmentAcceptor shipmentAcceptor;
    private final ShipmentRepository shipmentRepository;
    private final ShipmentMapper shipmentMapper;

    public ShipmentManager(ShipmentAcceptor shipmentAcceptor,
                           ShipmentRepository shipmentRepository,
                           ShipmentMapper shipmentMapper) {
        this.shipmentAcceptor = shipmentAcceptor;
        this.shipmentRepository = shipmentRepository;
        this.shipmentMapper = shipmentMapper;
    }

    @Override
    @Transactional
    public DistributeShipmentResponseDto distributeShipment(DistributeShipmentRequestDto distributeShipmentRequestDto) {
        for (RouteDto routeDto : distributeShipmentRequestDto) {
            this.distributeDeliveriesInRoute(routeDto);
        }
        return this.shipmentMapper.toDistributeShipmentResponseDto(distributeShipmentRequestDto);
    }

    private void distributeDeliveriesInRoute(RouteDto routeDto) {
        Integer deliveryPoint = routeDto.getDeliveryPoint();
        for (DeliveryDto deliveryDto : routeDto) {
            Shipment shipment = this.findByBarcode(deliveryDto.getBarcode());
            this.loadShipment(shipment);
            this.sendShipmentToAcceptor(shipment, deliveryPoint);
            this.saveShipment(shipment);
            this.shipmentMapper.updateDeliveryDtoStateFromShipment(deliveryDto,shipment);
        }
    }

    private void loadShipment(Shipment shipment) {
        shipment.load();
        this.saveShipment(shipment);
    }

    private void sendShipmentToAcceptor(Shipment shipment, Integer deliveryPoint) {
        this.shipmentAcceptor.acceptDelivery(shipment, deliveryPoint);
    }

    private void saveShipment(Shipment shipment) {
        this.shipmentRepository.save(shipment);
    }



    @Override
    public Shipment findByBarcode(String barcode) {
        return this.shipmentRepository.findByBarcode(barcode);
    }
}
