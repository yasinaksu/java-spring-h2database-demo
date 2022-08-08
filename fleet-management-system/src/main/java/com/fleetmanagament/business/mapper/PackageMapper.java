package com.fleetmanagament.business.mapper;

import com.fleetmanagament.entity.domain.Bag;
import com.fleetmanagament.entity.domain.DeliveryPoint;
import com.fleetmanagament.entity.domain.Package;
import com.fleetmanagament.entity.dto.packageshipment.AssignPackageToBagResponseDto;
import com.fleetmanagament.entity.dto.packageshipment.CreatePackageRequestDto;
import com.fleetmanagament.entity.dto.packageshipment.CreatePackageResponseDto;

public interface PackageMapper {
    Package toEntity(CreatePackageRequestDto createPackageRequestDto, DeliveryPoint deliveryPoint);
    CreatePackageResponseDto toDto(Package packageEntity);
    AssignPackageToBagResponseDto toDto(Package packageEntity, Bag bag);
}
