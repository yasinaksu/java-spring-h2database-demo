package com.fleetmanagament.entity.enumtype;

public enum DeliveryPointType {
    BRANCH(1, "Branch"),
    DISTRIBUTION_CENTER(2, "Distribution Center"),
    TRANSFER_CENTER(3, "Transfer Center");
    private final int value;
    private final String name;

    private DeliveryPointType(int value, String name) {
        this.value = value;
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public String getName() {
        return name;
    }
}
