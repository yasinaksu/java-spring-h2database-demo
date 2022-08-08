package com.fleetmanagament.controller;

import com.fleetmanagament.business.service.DeliveryPointService;
import com.fleetmanagament.business.service.VehicleService;
import com.fleetmanagament.entity.dto.deliverypoint.CreateDeliveryPointRequestDto;
import com.fleetmanagament.entity.dto.deliverypoint.CreateDeliveryPointResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/deliverypoints")
public class DeliveryPointController {
    private final DeliveryPointService deliveryPointService;
    @Autowired
    public DeliveryPointController(DeliveryPointService deliveryPointService) {
        this.deliveryPointService = deliveryPointService;
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<CreateDeliveryPointResponseDto> createDeliveryPoint(@RequestBody CreateDeliveryPointRequestDto createVehicleRequestDto){
        return ResponseEntity.ok(this.deliveryPointService.createDeliveryPoint(createVehicleRequestDto));
    }
}
