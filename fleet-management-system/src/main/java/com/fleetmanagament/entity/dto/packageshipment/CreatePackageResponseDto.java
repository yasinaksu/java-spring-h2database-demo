package com.fleetmanagament.entity.dto.packageshipment;

public class CreatePackageResponseDto {
    private final String barcode;
    private final Integer volumetricWeight;
    private final Integer deliveryPointValue;
    private final Integer state;

    private CreatePackageResponseDto(String barcode, Integer volumetricWeight, Integer deliveryPointValue, Integer state) {
        this.barcode = barcode;
        this.volumetricWeight = volumetricWeight;
        this.deliveryPointValue = deliveryPointValue;
        this.state = state;
    }

    public String getBarcode() {
        return barcode;
    }

    public Integer getVolumetricWeight() {
        return volumetricWeight;
    }

    public Integer getDeliveryPointValue() {
        return deliveryPointValue;
    }

    public Integer getState() {
        return state;
    }

    public static CreatePackageResponseDtoBuilder builder() {
        return new CreatePackageResponseDtoBuilder();
    }

    public static class CreatePackageResponseDtoBuilder {
        private String barcode;
        private Integer volumetricWeight;
        private Integer deliveryPointValue;
        private Integer state;

        public String getBarcode() {
            return barcode;
        }

        public CreatePackageResponseDtoBuilder withBarcode(String barcode) {
            this.barcode = barcode;
            return this;
        }

        public Integer getVolumetricWeight() {
            return volumetricWeight;
        }

        public CreatePackageResponseDtoBuilder withVolumetricWeight(Integer volumetricWeight) {
            this.volumetricWeight = volumetricWeight;
            return this;
        }

        public Integer getDeliveryPointValue() {
            return deliveryPointValue;
        }

        public CreatePackageResponseDtoBuilder withDeliveryPointValue(Integer deliveryPointValue) {
            this.deliveryPointValue = deliveryPointValue;
            return this;
        }

        public Integer getState() {
            return state;
        }

        public CreatePackageResponseDtoBuilder withState(Integer state) {
            this.state = state;
            return this;
        }

        public CreatePackageResponseDto build() {
            return new CreatePackageResponseDto(barcode, volumetricWeight, deliveryPointValue, state);
        }
    }
}
