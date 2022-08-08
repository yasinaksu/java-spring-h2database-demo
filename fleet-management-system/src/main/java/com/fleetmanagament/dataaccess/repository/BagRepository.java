package com.fleetmanagament.dataaccess.repository;

import com.fleetmanagament.entity.domain.Bag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BagRepository extends JpaRepository<Bag, String> {
    Bag findByBarcode(String barcode);
}
