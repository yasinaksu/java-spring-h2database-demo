package com.fleetmanagament.business.mapper;

import com.fleetmanagament.entity.domain.Bag;
import com.fleetmanagament.entity.domain.DeliveryPoint;
import com.fleetmanagament.entity.dto.bag.CreateBagRequestDto;
import com.fleetmanagament.entity.dto.bag.CreateBagResponseDto;

public interface BagMapper {
    Bag toEntity(CreateBagRequestDto createBagRequestDto, DeliveryPoint deliveryPoint);
    CreateBagResponseDto toDto(Bag bag);
}
