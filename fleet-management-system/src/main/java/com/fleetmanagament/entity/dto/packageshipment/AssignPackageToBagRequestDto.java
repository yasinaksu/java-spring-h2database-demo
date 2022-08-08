package com.fleetmanagament.entity.dto.packageshipment;

public class AssignPackageToBagRequestDto {
    private String packageBarcode;
    private String bagBarcode;

    public String getPackageBarcode() {
        return packageBarcode;
    }

    public void setPackageBarcode(String packageBarcode) {
        this.packageBarcode = packageBarcode;
    }

    public String getBagBarcode() {
        return bagBarcode;
    }

    public void setBagBarcode(String bagBarcode) {
        this.bagBarcode = bagBarcode;
    }
}
