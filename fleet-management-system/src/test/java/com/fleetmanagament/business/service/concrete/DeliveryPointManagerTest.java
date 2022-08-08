package com.fleetmanagament.business.service.concrete;

import com.fleetmanagament.business.mapper.DeliveryPointMapper;
import com.fleetmanagament.dataaccess.repository.DeliveryPointRepository;
import com.fleetmanagament.entity.domain.DeliveryPoint;
import com.fleetmanagament.entity.dto.deliverypoint.CreateDeliveryPointRequestDto;
import com.fleetmanagament.entity.dto.deliverypoint.CreateDeliveryPointResponseDto;
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
public class DeliveryPointManagerTest {

    @Mock
    private DeliveryPointMapper deliveryPointMapper;
    @Mock
    private DeliveryPointRepository deliveryPointRepository;
    @InjectMocks
    private DeliveryPointManager deliveryPointManager;

    @BeforeEach
    void setUp() {
        DeliveryPoint deliveryPoint = DeliveryPoint.create();
        deliveryPoint.setValue(1);
        deliveryPoint.setName("Branch");
        deliveryPoint.setId(1L);

        Mockito.when(
                this.deliveryPointMapper.toEntity(
                        Mockito.any(CreateDeliveryPointRequestDto.class))
        ).thenReturn(deliveryPoint);

        Mockito.when(
                this.deliveryPointRepository.save(Mockito.any())
        ).thenReturn(deliveryPoint);

        Mockito.when(
                this.deliveryPointMapper.toDto(Mockito.any(DeliveryPoint.class))
        ).thenReturn(CreateDeliveryPointResponseDto
                .builder()
                .withId(1L)
                .withName("Branch")
                .withValue(1).build());
    }

    @Test
    public void createDeliveryPoint() {
        CreateDeliveryPointRequestDto createDeliveryPointRequestDto = new CreateDeliveryPointRequestDto();
        createDeliveryPointRequestDto.setName("Branch");
        createDeliveryPointRequestDto.setValue(1);

        CreateDeliveryPointResponseDto createDeliveryPointResponseDto
                = this.deliveryPointManager.createDeliveryPoint(createDeliveryPointRequestDto);

        Assertions.assertThat(createDeliveryPointResponseDto.getId()).isEqualTo(1L);
    }
}