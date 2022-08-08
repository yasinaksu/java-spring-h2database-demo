package com.fleetmanagament.entity.dto.shipment;

import java.util.List;

public class DistributeShipmentResponseDto {
    private String plate;
    private List<RouteDto> route;

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public void setRoute(List<RouteDto> route) {
        this.route = route;
    }

    public List<RouteDto> getRoute() {
        return this.route;
    }
}
