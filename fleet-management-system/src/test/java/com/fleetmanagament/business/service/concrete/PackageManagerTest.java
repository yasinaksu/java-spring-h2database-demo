package com.fleetmanagament.business.service.concrete;

import com.fleetmanagament.business.constant.Messages;
import com.fleetmanagament.business.mapper.PackageMapper;
import com.fleetmanagament.business.mapper.concrete.PackageMapperImplementation;
import com.fleetmanagament.business.validation.PackageValidator;
import com.fleetmanagament.business.validation.implementation.PackageValidatorImplementation;
import com.fleetmanagament.dataaccess.repository.BagRepository;
import com.fleetmanagament.dataaccess.repository.DeliveryPointRepository;
import com.fleetmanagament.dataaccess.repository.PackageRepository;
import com.fleetmanagament.entity.domain.Bag;
import com.fleetmanagament.entity.domain.DeliveryPoint;
import com.fleetmanagament.entity.domain.Package;
import com.fleetmanagament.entity.dto.packageshipment.AssignPackageToBagRequestDto;
import com.fleetmanagament.entity.dto.packageshipment.CreatePackageRequestDto;
import com.fleetmanagament.entity.dto.packageshipment.CreatePackageResponseDto;
import com.fleetmanagament.entity.exception.PackageMustHaveSameDeliveryPointAsBagException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class PackageManagerTest {
    @Mock
    private PackageRepository packageRepository;
    @Mock
    private BagRepository bagRepository;
    @Spy
    private PackageMapper packageMapper = new PackageMapperImplementation();
    @Mock
    private DeliveryPointRepository deliveryPointRepository;
    @Spy
    private PackageValidator packageValidator = new PackageValidatorImplementation();
    @InjectMocks
    private PackageManager packageManager;

    @Test
    public void createPackage() {
        DeliveryPoint deliveryPoint = DeliveryPoint.create();
        deliveryPoint.setValue(1);
        deliveryPoint.setName("Branch");
        deliveryPoint.setId(1L);

        Mockito.when(
                this.deliveryPointRepository.findByValue(Mockito.anyInt())
        ).thenReturn(deliveryPoint);

        Package packageEntity = Package.create();
        packageEntity.setDeliveryPoint(deliveryPoint);
        packageEntity.setBarcode("P123456");
        packageEntity.setVolumetricWeight(10);


        Mockito.when(
                this.packageRepository.save(Mockito.any(Package.class))
        ).thenReturn(packageEntity);


        CreatePackageRequestDto createPackageRequestDto
                = new CreatePackageRequestDto();
        createPackageRequestDto.setBarcode("P123456");
        createPackageRequestDto.setVolumetricWeight(10);
        createPackageRequestDto.setDeliveryPointValue(1);
        CreatePackageResponseDto createPackageResponseDto
                = this.packageManager.createPackage(createPackageRequestDto);

        Assertions.assertThat(createPackageResponseDto.getBarcode()).isEqualTo(packageEntity.getBarcode());
    }

    @Test
    public void assignPackageToBag_throwsExceptionWhenPackageHasDifferentDeliveryPointFromBag() {

        DeliveryPoint packageDeliveryPoint = DeliveryPoint.create();
        packageDeliveryPoint.setValue(1);
        packageDeliveryPoint.setName("Branch");
        packageDeliveryPoint.setId(1L);

        Package packageEntity = Package.create();
        packageEntity.setDeliveryPoint(packageDeliveryPoint);
        packageEntity.setBarcode("P123456");
        packageEntity.setVolumetricWeight(10);

        Mockito.when(
                this.packageRepository.findByBarcode(Mockito.anyString())
        ).thenReturn(packageEntity);

        DeliveryPoint bagDeliveryPoint = DeliveryPoint.create();
        bagDeliveryPoint.setValue(3);
        bagDeliveryPoint.setName("Transfer Center");
        bagDeliveryPoint.setId(3L);

        Bag bag = Bag.create();
        bag.setDeliveryPoint(bagDeliveryPoint);
        bag.setBarcode("C11123");

        Mockito.when(
                this.bagRepository.findByBarcode(Mockito.anyString())
        ).thenReturn(bag);

        AssignPackageToBagRequestDto assignPackageToBagRequestDto
                = new AssignPackageToBagRequestDto();
        assignPackageToBagRequestDto.setPackageBarcode("P123456");
        assignPackageToBagRequestDto.setBagBarcode("C12345");

        Exception exception = assertThrows(PackageMustHaveSameDeliveryPointAsBagException.class, () -> {
            this.packageManager.assignPackageToBag(assignPackageToBagRequestDto);
        });
        String expectedMessage = Messages.LOADED_INTO_BAG_EXCEPTION_MESSAGE;

        Assertions.assertThat(exception.getMessage()).isEqualTo(expectedMessage);
    }

    @Test
    public void assignPackageToBag_worksWhenPackageHasSameDeliveryPointAsBag() {

        DeliveryPoint deliveryPoint = DeliveryPoint.create();
        deliveryPoint.setValue(1);
        deliveryPoint.setName("Branch");
        deliveryPoint.setId(1L);

        Package packageEntity = Package.create();
        packageEntity.setDeliveryPoint(deliveryPoint);
        packageEntity.setBarcode("P123456");
        packageEntity.setVolumetricWeight(10);

        Mockito.when(
                this.packageRepository.findByBarcode(Mockito.anyString())
        ).thenReturn(packageEntity);

        Bag bag = Bag.create();
        bag.setDeliveryPoint(deliveryPoint);
        bag.setBarcode("C11123");

        Mockito.when(
                this.bagRepository.findByBarcode(Mockito.anyString())
        ).thenReturn(bag);

        AssignPackageToBagRequestDto assignPackageToBagRequestDto
                = new AssignPackageToBagRequestDto();
        assignPackageToBagRequestDto.setPackageBarcode("P123456");
        assignPackageToBagRequestDto.setBagBarcode("C12345");

        assertDoesNotThrow(()->{
            this.packageManager.assignPackageToBag(assignPackageToBagRequestDto);
        });

        Assertions.assertThat(packageEntity.getBag())
                .isNotNull()
                .isEqualTo(bag);
    }
}