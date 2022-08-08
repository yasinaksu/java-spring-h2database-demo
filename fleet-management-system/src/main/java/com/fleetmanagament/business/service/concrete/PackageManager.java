package com.fleetmanagament.business.service.concrete;

import com.fleetmanagament.business.mapper.PackageMapper;
import com.fleetmanagament.business.service.PackageService;
import com.fleetmanagament.business.validation.PackageValidator;
import com.fleetmanagament.dataaccess.repository.BagRepository;
import com.fleetmanagament.dataaccess.repository.DeliveryPointRepository;
import com.fleetmanagament.dataaccess.repository.PackageRepository;
import com.fleetmanagament.entity.domain.Bag;
import com.fleetmanagament.entity.domain.DeliveryPoint;
import com.fleetmanagament.entity.domain.Package;
import com.fleetmanagament.entity.dto.packageshipment.AssignPackageToBagRequestDto;
import com.fleetmanagament.entity.dto.packageshipment.AssignPackageToBagResponseDto;
import com.fleetmanagament.entity.dto.packageshipment.CreatePackageRequestDto;
import com.fleetmanagament.entity.dto.packageshipment.CreatePackageResponseDto;
import com.fleetmanagament.entity.exception.PackageMustHaveSameDeliveryPointAsBagException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PackageManager implements PackageService {
    private final PackageRepository packageRepository;
    private final BagRepository bagRepository;
    private final PackageMapper packageMapper;
    private final DeliveryPointRepository deliveryPointRepository;
    private final PackageValidator packageValidator;

    @Autowired
    public PackageManager(
            PackageRepository packageRepository,
            BagRepository bagRepository,
            PackageMapper packageMapper,
            DeliveryPointRepository deliveryPointRepository,
            PackageValidator packageValidator) {
        this.packageRepository = packageRepository;
        this.bagRepository = bagRepository;
        this.packageMapper = packageMapper;
        this.deliveryPointRepository = deliveryPointRepository;
        this.packageValidator = packageValidator;
    }

    @Override
    @Transactional
    public CreatePackageResponseDto createPackage(CreatePackageRequestDto createPackageRequestDto) {
        DeliveryPoint deliveryPoint
                = this.deliveryPointRepository.findByValue(createPackageRequestDto.getDeliveryPointValue());
        Package packageToCreate = this.packageMapper.toEntity(createPackageRequestDto, deliveryPoint);
        this.packageRepository.save(packageToCreate);
        return this.packageMapper.toDto(packageToCreate);
    }

    @Override
    @Transactional
    public AssignPackageToBagResponseDto assignPackageToBag(AssignPackageToBagRequestDto assignPackageToBagRequestDto) throws PackageMustHaveSameDeliveryPointAsBagException {
        Package packageEntity = this.packageRepository.findByBarcode(assignPackageToBagRequestDto.getPackageBarcode());
        Bag bag = this.bagRepository.findByBarcode(assignPackageToBagRequestDto.getBagBarcode());
        //SRP ihlali yapmışım validasyon içinde paketi torbaya yüklemişim.
        this.packageValidator.assignPackageToBagValidation(packageEntity,bag);
        this.packageRepository.save(packageEntity);
        return this.packageMapper.toDto(packageEntity, bag);
    }
}
