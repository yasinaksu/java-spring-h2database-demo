package com.fleetmanagament.entity.dto.bag;

import com.fleetmanagament.entity.dto.packageshipment.CreatePackageResponseDto;

public class CreateBagResponseDto {
    private final String barcode;
    private final Integer state;
    private final Integer deliveryPointValue;

    private CreateBagResponseDto(String barcode, Integer deliveryPointValue, Integer state) {
        this.barcode = barcode;
        this.state = state;
        this.deliveryPointValue = deliveryPointValue;
    }

    public String getBarcode() {
        return barcode;
    }

    public Integer getDeliveryPointValue() {
        return deliveryPointValue;
    }

    public Integer getState() {
        return state;
    }

    public static CreateBagResponseDtoBuilder builder(){
        return new CreateBagResponseDtoBuilder();
    }

    public static class CreateBagResponseDtoBuilder{
        private String barcode;
        private Integer deliveryPointValue;
        private Integer state;

        public CreateBagResponseDtoBuilder withBarcode(String barcode) {
            this.barcode = barcode;
            return this;
        }

        public CreateBagResponseDtoBuilder withDeliveryPointValue(Integer deliveryPointValue) {
            this.deliveryPointValue = deliveryPointValue;
            return this;
        }

        public CreateBagResponseDtoBuilder withState(Integer state) {
            this.state = state;
            return this;
        }

        public CreateBagResponseDto build(){
            return new CreateBagResponseDto(barcode,deliveryPointValue,state);
        }
    }
}
