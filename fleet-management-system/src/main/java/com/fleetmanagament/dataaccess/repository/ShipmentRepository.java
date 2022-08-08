package com.fleetmanagament.dataaccess.repository;

import com.fleetmanagament.entity.domain.Shipment;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Primary
public interface ShipmentRepository extends JpaRepository<Shipment, String> {
    Shipment findByBarcode(String barcode);
}
