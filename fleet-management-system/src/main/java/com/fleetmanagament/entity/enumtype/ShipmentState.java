package com.fleetmanagament.entity.enumtype;

public enum ShipmentState {
    CREATED(1), LOADED_INTO_BAG(2), LOADED(3), UNLOADED(4);
    private final int value;

    private ShipmentState(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
