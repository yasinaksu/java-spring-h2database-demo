package com.fleetmanagament.entity.dto.shared;

public class ErrorResponseDto {
    private final Boolean success;
    private final String message;
    private ErrorResponseDto(Boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public Boolean getSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public static ErrorResponseDtoBuilder builder(){
        return new ErrorResponseDtoBuilder();
    }

    public static class ErrorResponseDtoBuilder{
        private Boolean success;
        private String message;

        public ErrorResponseDtoBuilder withSuccess(Boolean success) {
            this.success = success;
            return this;
        }

        public ErrorResponseDtoBuilder withMessage(String message) {
            this.message = message;
            return this;
        }

        public ErrorResponseDto build(){
            return new ErrorResponseDto(success,message);
        }
    }
}
