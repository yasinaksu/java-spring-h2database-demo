package com.fleetmanagament.entity.dto.bag;

public class CreateBagRequestDto {
    private String barcode;
    private Integer deliveryPointValue;

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public Integer getDeliveryPointValue() {
        return deliveryPointValue;
    }

    public void setDeliveryPointValue(Integer deliveryPointValue) {
        this.deliveryPointValue = deliveryPointValue;
    }
}

