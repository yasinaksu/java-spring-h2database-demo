package com.fleetmanagament.entity.domain;

import javax.persistence.*;

@Entity
@Table(name = "shipments")
@Inheritance(
        strategy = InheritanceType.JOINED
)
public abstract class Shipment {
    @Id
    @Column(nullable = false)
    protected String barcode;
    protected Integer state;

    @ManyToOne
    @JoinColumn(name = "delivery_point_id")
    protected DeliveryPoint deliveryPoint;

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public Integer getState() {
        return state;
    }

    public DeliveryPoint getDeliveryPoint() {
        return deliveryPoint;
    }

    public void setDeliveryPoint(DeliveryPoint deliveryPoint) {
        this.deliveryPoint = deliveryPoint;
    }

    public abstract void unload(Integer deliveryPoint);
    public abstract void load();
}
