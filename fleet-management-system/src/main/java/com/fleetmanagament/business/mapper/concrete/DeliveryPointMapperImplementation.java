package com.fleetmanagament.business.mapper.concrete;

import com.fleetmanagament.business.mapper.DeliveryPointMapper;
import com.fleetmanagament.entity.domain.DeliveryPoint;
import com.fleetmanagament.entity.dto.deliverypoint.CreateDeliveryPointRequestDto;
import com.fleetmanagament.entity.dto.deliverypoint.CreateDeliveryPointResponseDto;
import org.springframework.stereotype.Component;

@Component
public class DeliveryPointMapperImplementation implements DeliveryPointMapper {
    @Override
    public DeliveryPoint toEntity(CreateDeliveryPointRequestDto createDeliveryPointRequestDto) {
        return DeliveryPoint.create()
                .setName(createDeliveryPointRequestDto.getName())
                .setValue(createDeliveryPointRequestDto.getValue());
    }

    @Override
    public CreateDeliveryPointResponseDto toDto(DeliveryPoint deliveryPoint) {
        return CreateDeliveryPointResponseDto.builder()
                .withId(deliveryPoint.getId())
                .withName(deliveryPoint.getName())
                .withValue(deliveryPoint.getValue())
                .build();
    }
}
