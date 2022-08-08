package com.fleetmanagament.entity.dto.shipment;

public class DeliveryDto {
    private String barcode;
    private Integer state;
    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}
