package com.fleetmanagament.dataaccess.repository;

import com.fleetmanagament.entity.domain.DeliveryPoint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryPointRepository extends JpaRepository<DeliveryPoint, Long> {
    DeliveryPoint findByValue(Integer value);
}
