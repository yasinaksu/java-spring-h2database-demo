package com.fleetmanagament.entity.dto.shipment;

import java.util.Iterator;
import java.util.List;

public class RouteDto implements Iterable<DeliveryDto>{
    private Integer deliveryPoint;
    private List<DeliveryDto> deliveries;

    public Integer getDeliveryPoint() {
        return deliveryPoint;
    }

    public void setDeliveryPoint(Integer deliveryPoint) {
        this.deliveryPoint = deliveryPoint;
    }

    public void setDeliveries(List<DeliveryDto> deliveries) {
        this.deliveries = deliveries;
    }

    public List<DeliveryDto> getDeliveries() {
        return deliveries;
    }

    @Override
    public Iterator<DeliveryDto> iterator() {
        return this.deliveries.iterator();
    }
}
