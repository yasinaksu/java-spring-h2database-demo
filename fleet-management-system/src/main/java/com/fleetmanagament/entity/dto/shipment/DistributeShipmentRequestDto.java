package com.fleetmanagament.entity.dto.shipment;

import java.util.Iterator;
import java.util.List;

public class DistributeShipmentRequestDto implements Iterable<RouteDto> {
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

    @Override
    public Iterator<RouteDto> iterator() {
        return route.iterator();
    }
}
