package com.fleetmanagament.business.service;

import com.fleetmanagament.entity.dto.packageshipment.AssignPackageToBagRequestDto;
import com.fleetmanagament.entity.dto.packageshipment.AssignPackageToBagResponseDto;
import com.fleetmanagament.entity.dto.packageshipment.CreatePackageRequestDto;
import com.fleetmanagament.entity.dto.packageshipment.CreatePackageResponseDto;
import com.fleetmanagament.entity.exception.PackageMustHaveSameDeliveryPointAsBagException;

public interface PackageService {
    CreatePackageResponseDto createPackage(CreatePackageRequestDto createPackageRequestDto);
    AssignPackageToBagResponseDto assignPackageToBag(AssignPackageToBagRequestDto assignPackageToBagRequestDto) throws PackageMustHaveSameDeliveryPointAsBagException;
}
