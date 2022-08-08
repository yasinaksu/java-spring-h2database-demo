package com.fleetmanagament.controller;

import com.fleetmanagament.business.service.ShipmentService;
import com.fleetmanagament.business.service.VehicleService;
import com.fleetmanagament.entity.dto.shipment.DistributeShipmentRequestDto;
import com.fleetmanagament.entity.dto.shipment.DistributeShipmentResponseDto;
import com.fleetmanagament.entity.dto.vehicle.CreateVehicleRequestDto;
import com.fleetmanagament.entity.dto.vehicle.CreateVehicleResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/vehicles")
public class VehicleController {

    private final VehicleService vehicleService;
    private final ShipmentService shipmentService;
    @Autowired
    public VehicleController(VehicleService vehicleService, ShipmentService shipmentService) {
        this.vehicleService = vehicleService;
        this.shipmentService = shipmentService;
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<CreateVehicleResponseDto> create(@RequestBody CreateVehicleRequestDto createVehicleRequestDto){
        return ResponseEntity.ok(this.vehicleService.createVehicle(createVehicleRequestDto));
    }

    @PostMapping(path = "shipments")
    @ResponseBody
    public ResponseEntity<DistributeShipmentResponseDto> distributeShipment(
            @RequestBody DistributeShipmentRequestDto distributeShipmentRequestDto){
        return ResponseEntity.ok(this.shipmentService.distributeShipment(distributeShipmentRequestDto));
    }
}
