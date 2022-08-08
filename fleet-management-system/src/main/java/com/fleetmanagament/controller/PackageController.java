package com.fleetmanagament.controller;

import com.fleetmanagament.business.service.PackageService;
import com.fleetmanagament.entity.dto.packageshipment.AssignPackageToBagRequestDto;
import com.fleetmanagament.entity.dto.packageshipment.AssignPackageToBagResponseDto;
import com.fleetmanagament.entity.dto.packageshipment.CreatePackageRequestDto;
import com.fleetmanagament.entity.dto.packageshipment.CreatePackageResponseDto;
import com.fleetmanagament.entity.exception.PackageMustHaveSameDeliveryPointAsBagException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/packages")
public class PackageController {
    private final PackageService packageService;

    @Autowired
    public PackageController(PackageService packageService) {
        this.packageService = packageService;
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<CreatePackageResponseDto> createPackage(@RequestBody CreatePackageRequestDto createPackageRequestDto) {
        return ResponseEntity.ok(this.packageService.createPackage(createPackageRequestDto));
    }

    @PutMapping(path = "bag")
    @ResponseBody
    public ResponseEntity<AssignPackageToBagResponseDto> assignPackageToBag(
            @RequestBody AssignPackageToBagRequestDto assignPackageToBagRequestDto) throws PackageMustHaveSameDeliveryPointAsBagException {
        return ResponseEntity.ok(this.packageService.assignPackageToBag(assignPackageToBagRequestDto));
    }
}
