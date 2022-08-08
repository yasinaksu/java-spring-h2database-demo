package com.fleetmanagament.entity.domain;

import com.fleetmanagament.entity.enumtype.ShipmentState;
import com.fleetmanagament.entity.exception.AttemptDeliverWrongPointException;
import com.fleetmanagament.entity.exception.PackageMustHaveSameDeliveryPointAsBagException;
import com.fleetmanagament.entity.shipment.ObserverShipment;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "packages")
public class Package extends Shipment implements ObserverShipment {
    private Integer volumetricWeight;
    @ManyToOne
    @JoinColumn(name = "bag_barcode")
    private Bag bag;

    protected Package() {

    }

    public Integer getVolumetricWeight() {
        return volumetricWeight;
    }

    public void setVolumetricWeight(Integer volumetricWeight) {
        this.volumetricWeight = volumetricWeight;
    }

    public Bag getBag() {
        return bag;
    }

    public void loadIntoBag(Bag bag){
        this.bag = bag;
        this.state = ShipmentState.LOADED_INTO_BAG.getValue();
    }

    public static Package create() {
        Package packageEntity = new Package();
        packageEntity.state = ShipmentState.CREATED.getValue();
        return packageEntity;
    }

    @Override
    public void unload(Integer deliveryPoint) {
        this.state = ShipmentState.UNLOADED.getValue();
    }

    @Override
    public void load() {
        this.state = ShipmentState.LOADED.getValue();
    }

    @Override
    public void update(Integer state) {
        this.state = state;
    }
}
