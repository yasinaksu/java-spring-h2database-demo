package com.fleetmanagament.dataaccess.repository;

import com.fleetmanagament.entity.domain.Package;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PackageRepository extends JpaRepository<Package, String> {
    Package findByBarcode(String barcode);
}
