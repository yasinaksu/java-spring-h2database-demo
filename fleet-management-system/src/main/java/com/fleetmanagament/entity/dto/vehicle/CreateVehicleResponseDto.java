package com.fleetmanagament.entity.dto.vehicle;

public class CreateVehicleResponseDto {
    private final Long id;
    private final String licensePlate;

    private CreateVehicleResponseDto(Long id, String licensePlate) {
        this.id = id;
        this.licensePlate = licensePlate;
    }

    public Long getId() {
        return id;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public static CreateVehicleResponseDtoBuilder builder() {
        return new CreateVehicleResponseDtoBuilder();
    }

    public static class CreateVehicleResponseDtoBuilder {
        private Long id;
        private String licensePlate;

        public Long getId() {
            return id;
        }

        public CreateVehicleResponseDtoBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public String getLicensePlate() {
            return licensePlate;
        }

        public CreateVehicleResponseDtoBuilder withLicensePlate(String licensePlate) {
            this.licensePlate = licensePlate;
            return this;
        }

        public CreateVehicleResponseDto build() {
            return new CreateVehicleResponseDto(id, licensePlate);
        }
    }
}
