package com.fleetmanagament.business.mapper.concrete;

import com.fleetmanagament.business.mapper.BagMapper;
import com.fleetmanagament.dataaccess.repository.DeliveryPointRepository;
import com.fleetmanagament.entity.domain.Bag;
import com.fleetmanagament.entity.domain.DeliveryPoint;
import com.fleetmanagament.entity.dto.bag.CreateBagRequestDto;
import com.fleetmanagament.entity.dto.bag.CreateBagResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BagMapperImplementation implements BagMapper {

    @Override
    public Bag toEntity(CreateBagRequestDto createBagRequestDto, DeliveryPoint deliveryPoint) {
        Bag bag = Bag.create();
        bag.setDeliveryPoint(deliveryPoint);
        bag.setBarcode(createBagRequestDto.getBarcode());
        return bag;
    }

    @Override
    public CreateBagResponseDto toDto(Bag bag) {
        return CreateBagResponseDto.builder()
                .withBarcode(bag.getBarcode())
                .withState(bag.getState())
                .withDeliveryPointValue(bag.getDeliveryPoint().getValue())
                .build();
    }
}
