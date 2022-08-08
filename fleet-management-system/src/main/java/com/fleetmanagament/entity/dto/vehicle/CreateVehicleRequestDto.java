package com.fleetmanagament.entity.dto.vehicle;

public class CreateVehicleRequestDto {
    private String licensePlate;
    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }
}
