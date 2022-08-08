package com.fleetmanagament.business.service.concrete;

import com.fleetmanagament.business.mapper.BagMapper;
import com.fleetmanagament.business.service.BagService;
import com.fleetmanagament.dataaccess.repository.BagRepository;
import com.fleetmanagament.dataaccess.repository.DeliveryPointRepository;
import com.fleetmanagament.entity.domain.Bag;
import com.fleetmanagament.entity.domain.DeliveryPoint;
import com.fleetmanagament.entity.dto.bag.CreateBagRequestDto;
import com.fleetmanagament.entity.dto.bag.CreateBagResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BagManager implements BagService {
    private final BagMapper bagMapper;
    private final BagRepository bagRepository;
    private final DeliveryPointRepository deliveryPointRepository;

    @Autowired
    public BagManager(BagMapper bagMapper, BagRepository bagRepository, DeliveryPointRepository deliveryPointRepository) {
        this.bagMapper = bagMapper;
        this.bagRepository = bagRepository;
        this.deliveryPointRepository = deliveryPointRepository;
    }

    @Override
    public CreateBagResponseDto createBag(CreateBagRequestDto createBagRequestDto) {
        DeliveryPoint deliveryPoint
                = this.deliveryPointRepository.findByValue(createBagRequestDto.getDeliveryPointValue());
        Bag bagToCreate = this.bagMapper.toEntity(createBagRequestDto, deliveryPoint);
        this.bagRepository.save(bagToCreate);
        return this.bagMapper.toDto(bagToCreate);
    }

}
