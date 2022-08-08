package com.fleetmanagament.entity.dto.deliverypoint;

public class CreateDeliveryPointResponseDto {
    private final Long id;
    private final String name;
    private final Integer value;

    private CreateDeliveryPointResponseDto(Long id, String name, Integer value) {
        this.id = id;
        this.name = name;
        this.value = value;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getValue() {
        return value;
    }

    public static CreateDeliveryPointResponseDtoBuilder builder() {
        return new CreateDeliveryPointResponseDtoBuilder();
    }

    public static class CreateDeliveryPointResponseDtoBuilder {
        private Long id;
        private String name;
        private Integer value;

        public Long getId() {
            return id;
        }

        public CreateDeliveryPointResponseDtoBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public String getName() {
            return name;
        }

        public CreateDeliveryPointResponseDtoBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public Integer getValue() {
            return value;
        }

        public CreateDeliveryPointResponseDtoBuilder withValue(Integer value) {
            this.value = value;
            return this;
        }

        public CreateDeliveryPointResponseDto build() {
            return new CreateDeliveryPointResponseDto(id, name, value);
        }
    }

}
