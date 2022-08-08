package com.fleetmanagament.entity.dto.packageshipment;

public class AssignPackageToBagResponseDto {
    private final String packageBarcode;
    private final Integer packageState;
    private final Integer packageDeliveryPointValue;
    private final String bagBarcode;
    private final Integer bagState;
    private final Integer bagDeliveryPointValue;

    private AssignPackageToBagResponseDto(String packageBarcode,
                                         Integer packageState,
                                         Integer packageDeliveryPointValue,
                                         String bagBarcode,
                                         Integer bagState,
                                         Integer bagDeliveryPointValue) {
        this.packageBarcode = packageBarcode;
        this.packageState = packageState;
        this.packageDeliveryPointValue = packageDeliveryPointValue;
        this.bagBarcode = bagBarcode;
        this.bagState = bagState;
        this.bagDeliveryPointValue = bagDeliveryPointValue;
    }

    public String getPackageBarcode() {
        return packageBarcode;
    }

    public Integer getPackageState() {
        return packageState;
    }

    public Integer getPackageDeliveryPointValue() {
        return packageDeliveryPointValue;
    }

    public String getBagBarcode() {
        return bagBarcode;
    }

    public Integer getBagState() {
        return bagState;
    }

    public Integer getBagDeliveryPointValue() {
        return bagDeliveryPointValue;
    }

    public static AssignPackageToBagResponseDtoBuilder builder(){
        return new AssignPackageToBagResponseDtoBuilder();
    }

    public static class AssignPackageToBagResponseDtoBuilder{
        private String packageBarcode;
        private Integer packageState;
        private Integer packageDeliveryPointValue;
        private String bagBarcode;
        private Integer bagState;
        private Integer bagDeliveryPointValue;

        public AssignPackageToBagResponseDtoBuilder withPackageBarcode(String packageBarcode) {
            this.packageBarcode = packageBarcode;
            return this;
        }

        public AssignPackageToBagResponseDtoBuilder withPackageState(Integer packageState) {
            this.packageState = packageState;
            return this;
        }

        public AssignPackageToBagResponseDtoBuilder withPackageDeliveryPointValue(Integer packageDeliveryPointValue) {
            this.packageDeliveryPointValue = packageDeliveryPointValue;
            return this;
        }

        public AssignPackageToBagResponseDtoBuilder withBagBarcode(String bagBarcode) {
            this.bagBarcode = bagBarcode;
            return this;
        }

        public AssignPackageToBagResponseDtoBuilder withBagState(Integer bagState) {
            this.bagState = bagState;
            return this;
        }

        public AssignPackageToBagResponseDtoBuilder withBagDeliveryPointValue(Integer bagDeliveryPointValue) {
            this.bagDeliveryPointValue = bagDeliveryPointValue;
            return this;
        }

        public AssignPackageToBagResponseDto build(){
            return new AssignPackageToBagResponseDto(
                    packageBarcode,
                    packageState,
                    packageDeliveryPointValue,
                    bagBarcode,
                    bagState,
                    bagDeliveryPointValue);
        }
    }
}
