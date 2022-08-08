package com.fleetmanagament.business.mapper.concrete;

import com.fleetmanagament.business.mapper.PackageMapper;
import com.fleetmanagament.dataaccess.repository.BagRepository;
import com.fleetmanagament.dataaccess.repository.DeliveryPointRepository;
import com.fleetmanagament.entity.domain.Bag;
import com.fleetmanagament.entity.domain.DeliveryPoint;
import com.fleetmanagament.entity.domain.Package;
import com.fleetmanagament.entity.dto.packageshipment.AssignPackageToBagRequestDto;
import com.fleetmanagament.entity.dto.packageshipment.AssignPackageToBagResponseDto;
import com.fleetmanagament.entity.dto.packageshipment.CreatePackageRequestDto;
import com.fleetmanagament.entity.dto.packageshipment.CreatePackageResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PackageMapperImplementation implements PackageMapper {

    @Override
    public Package toEntity(CreatePackageRequestDto createPackageRequestDto, DeliveryPoint deliveryPoint) {
        Package packageEntity = Package.create();
        packageEntity.setBarcode(createPackageRequestDto.getBarcode());
        packageEntity.setVolumetricWeight(createPackageRequestDto.getVolumetricWeight());
        packageEntity.setDeliveryPoint(deliveryPoint);
        return packageEntity;
    }

    @Override
    public CreatePackageResponseDto toDto(Package packageEntity) {
        return CreatePackageResponseDto.builder()
                .withBarcode(packageEntity.getBarcode())
                .withState(packageEntity.getState())
                .withDeliveryPointValue(packageEntity.getDeliveryPoint().getValue())
                .withVolumetricWeight(packageEntity.getVolumetricWeight())
                .build();
    }

    @Override
    public AssignPackageToBagResponseDto toDto(Package packageEntity, Bag bag) {
        return AssignPackageToBagResponseDto.builder()
                .withBagBarcode(bag.getBarcode())
                .withPackageBarcode(packageEntity.getBarcode())
                .withBagState(bag.getState())
                .withPackageDeliveryPointValue(packageEntity.getDeliveryPoint().getValue())
                .withBagDeliveryPointValue(bag.getDeliveryPoint().getValue())
                .withPackageState(packageEntity.getState())
                .build();
    }
}
