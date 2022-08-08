package com.fleetmanagament.business.service.concrete;

import com.fleetmanagament.business.mapper.DeliveryPointMapper;
import com.fleetmanagament.business.service.DeliveryPointService;
import com.fleetmanagament.dataaccess.repository.DeliveryPointRepository;
import com.fleetmanagament.entity.domain.DeliveryPoint;
import com.fleetmanagament.entity.dto.deliverypoint.CreateDeliveryPointRequestDto;
import com.fleetmanagament.entity.dto.deliverypoint.CreateDeliveryPointResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeliveryPointManager implements DeliveryPointService {
    private final DeliveryPointMapper deliveryPointMapper;
    private final DeliveryPointRepository deliveryPointRepository;

    @Autowired
    public DeliveryPointManager(DeliveryPointMapper deliveryPointMapper, DeliveryPointRepository deliveryPointRepository) {
        this.deliveryPointMapper = deliveryPointMapper;
        this.deliveryPointRepository = deliveryPointRepository;
    }

    @Override
    public CreateDeliveryPointResponseDto createDeliveryPoint(CreateDeliveryPointRequestDto createDeliveryPointRequestDto) {
        DeliveryPoint deliveryPointToCreate
                = this.deliveryPointMapper.toEntity(createDeliveryPointRequestDto);
        this.deliveryPointRepository.save(deliveryPointToCreate);
        return this.deliveryPointMapper.toDto(deliveryPointToCreate);
    }
}
