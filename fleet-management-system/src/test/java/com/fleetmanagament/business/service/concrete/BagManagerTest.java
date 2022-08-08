package com.fleetmanagament.business.service.concrete;

import com.fleetmanagament.business.mapper.BagMapper;
import com.fleetmanagament.dataaccess.repository.BagRepository;
import com.fleetmanagament.dataaccess.repository.DeliveryPointRepository;
import com.fleetmanagament.entity.domain.Bag;
import com.fleetmanagament.entity.domain.DeliveryPoint;
import com.fleetmanagament.entity.dto.bag.CreateBagRequestDto;
import com.fleetmanagament.entity.dto.bag.CreateBagResponseDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class BagManagerTest {
    @Mock
    private BagMapper bagMapper;
    @Mock
    private BagRepository bagRepository;
    @Mock
    private DeliveryPointRepository deliveryPointRepository;
    @InjectMocks
    private BagManager bagManager;

    @BeforeEach
    void setUp() {
        DeliveryPoint deliveryPoint = DeliveryPoint.create();
        deliveryPoint.setValue(1);
        deliveryPoint.setName("Branch");
        deliveryPoint.setId(1L);

        Bag bag = Bag.create();
        bag.setDeliveryPoint(deliveryPoint);
        bag.setBarcode("C720800");

        Mockito.when(
                this.deliveryPointRepository.findByValue(Mockito.anyInt())
        ).thenReturn(deliveryPoint);

        Mockito.when(
                this.bagMapper.toEntity(
                        Mockito.any(CreateBagRequestDto.class),
                        Mockito.any(DeliveryPoint.class))
        ).thenReturn(bag);

        Mockito.when(
                this.bagRepository.save(Mockito.any(Bag.class))
        ).thenReturn(bag);

        Mockito.when(
                this.bagMapper.toDto(Mockito.any(Bag.class))
        ).thenReturn(CreateBagResponseDto.builder()
                        .withDeliveryPointValue(deliveryPoint.getValue())
                        .withState(bag.getState())
                        .withBarcode(bag.getBarcode()).build());
    }

    @Test
    public void createBag() {
        CreateBagRequestDto createBagRequestDto = new CreateBagRequestDto();
        createBagRequestDto.setBarcode("C720800");
        createBagRequestDto.setDeliveryPointValue(1);
        CreateBagResponseDto createBagResponseDto = this.bagManager.createBag(createBagRequestDto);

        Assertions.assertThat(createBagResponseDto.getBarcode()).isEqualTo("C720800");
    }
}