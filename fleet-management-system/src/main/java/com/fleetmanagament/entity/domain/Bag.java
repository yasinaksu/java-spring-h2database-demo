package com.fleetmanagament.entity.domain;

import com.fleetmanagament.entity.enumtype.ShipmentState;
import com.fleetmanagament.entity.exception.AttemptDeliverWrongPointException;
import com.fleetmanagament.entity.shipment.ObservableShipment;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "bags")
public class Bag extends Shipment implements ObservableShipment {

    @OneToMany(mappedBy = "bag", fetch = FetchType.EAGER)
    private List<Package> packages = new ArrayList<>();

    protected Bag() {

    }

    public static Bag create() {
        Bag bag = new Bag();
        bag.state = ShipmentState.CREATED.getValue();
        return bag;
    }

    @Override
    public void unload(Integer deliveryPoint) {
        this.state = ShipmentState.UNLOADED.getValue();
        notifyObservers();
    }

    @Override
    public void load() {
        this.state = ShipmentState.LOADED.getValue();
        notifyObservers();
    }

    @Override
    public void notifyObservers() {
        for (Package packageEntity : this.packages) {
            packageEntity.update(this.state);
        }
    }
}
