package com.fleetmanagament.core.aspect.exception;

import com.fleetmanagament.entity.dto.shared.ErrorResponseDto;
import com.fleetmanagament.entity.exception.PackageMustHaveSameDeliveryPointAsBagException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestControllerExceptionHandler {

    @ExceptionHandler({PackageMustHaveSameDeliveryPointAsBagException.class})
    public ResponseEntity<ErrorResponseDto> packageMustHaveSameDeliveryPointAsBagException(PackageMustHaveSameDeliveryPointAsBagException ex) {
        return ResponseEntity.badRequest().body(
                ErrorResponseDto.builder()
                        .withMessage(ex.getMessage())
                        .withSuccess(false)
                        .build());

    }

    @ExceptionHandler({Exception.class, Throwable.class})
    public ResponseEntity<ErrorResponseDto> packageMustHaveSameDeliveryPointAsBagException(Exception ex) {
        return ResponseEntity.internalServerError().body(
                ErrorResponseDto.builder()
                        .withMessage("Oppss something went wrong.")
                        .withSuccess(false)
                        .build());

    }
}
