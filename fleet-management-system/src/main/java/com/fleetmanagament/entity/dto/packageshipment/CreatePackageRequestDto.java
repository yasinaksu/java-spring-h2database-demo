package com.fleetmanagament.entity.dto.packageshipment;

import com.fleetmanagament.entity.domain.DeliveryPoint;

public class CreatePackageRequestDto {
    private String barcode;
    private Integer volumetricWeight;
    private Integer deliveryPointValue;

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public Integer getVolumetricWeight() {
        return volumetricWeight;
    }

    public void setVolumetricWeight(Integer volumetricWeight) {
        this.volumetricWeight = volumetricWeight;
    }

    public Integer getDeliveryPointValue() {
        return deliveryPointValue;
    }

    public void setDeliveryPointValue(Integer deliveryPointValue) {
        this.deliveryPointValue = deliveryPointValue;
    }
}
