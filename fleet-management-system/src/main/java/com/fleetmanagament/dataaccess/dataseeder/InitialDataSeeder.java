package com.fleetmanagament.dataaccess.dataseeder;

import com.fleetmanagament.dataaccess.repository.DeliveryPointRepository;
import com.fleetmanagament.dataaccess.repository.ShipmentRepository;
import com.fleetmanagament.dataaccess.repository.VehicleRepository;
import com.fleetmanagament.entity.domain.Bag;
import com.fleetmanagament.entity.domain.Package;
import com.fleetmanagament.entity.domain.DeliveryPoint;
import com.fleetmanagament.entity.domain.Vehicle;
import com.fleetmanagament.entity.enumtype.DeliveryPointType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;

//@Component
public class InitialDataSeeder {

    private final VehicleRepository vehicleRepository;
    private final DeliveryPointRepository deliveryPointRepository;
    private final ShipmentRepository shipmentRepository;
    @Autowired
    public InitialDataSeeder(VehicleRepository vehicleRepository, DeliveryPointRepository deliveryPointRepository, ShipmentRepository shipmentRepository) {
        this.vehicleRepository = vehicleRepository;
        this.deliveryPointRepository = deliveryPointRepository;
        this.shipmentRepository = shipmentRepository;
    }

    @PostConstruct
    @Transactional
    public void seed(){
        addVehicle();
        addDeliveryPoint();
        addBag();
        addPackage();
        assignPackageToBag();
    }

    private void addVehicle(){
        Vehicle vehicle = Vehicle.create()
                .setLicensePlate("34 TL 34");
        this.vehicleRepository.save(vehicle);
    }

    private void addDeliveryPoint(){
        DeliveryPoint deliveryPoint = DeliveryPoint.create().setValue(1).setName("Branch");
        this.deliveryPointRepository.save(deliveryPoint);

        deliveryPoint = DeliveryPoint.create().setName("Distribution Center").setValue(2);
        this.deliveryPointRepository.save(deliveryPoint);

        deliveryPoint = DeliveryPoint.create().setName("Transfer Center").setValue(3);
        this.deliveryPointRepository.save(deliveryPoint);
    }

    private void addBag() {
        Bag bag = Bag.create();
        bag.setBarcode("C725799");
        DeliveryPoint deliveryPoint = this.deliveryPointRepository.findByValue(DeliveryPointType.DISTRIBUTION_CENTER.getValue());
        bag.setDeliveryPoint(deliveryPoint);
        this.shipmentRepository.save(bag);

        bag = Bag.create();
        bag.setBarcode("C725800");
        deliveryPoint = this.deliveryPointRepository.findByValue(DeliveryPointType.TRANSFER_CENTER.getValue());
        bag.setDeliveryPoint(deliveryPoint);
        this.shipmentRepository.save(bag);
    }

    private void addPackage() {
        Package packageEntity = Package.create();
        packageEntity.setBarcode("P7988000121");
        DeliveryPoint deliveryPoint = this.deliveryPointRepository.findByValue(DeliveryPointType.BRANCH.getValue());
        packageEntity.setDeliveryPoint(deliveryPoint);
        packageEntity.setVolumetricWeight(5);
        this.shipmentRepository.save(packageEntity);

        packageEntity = Package.create();
        packageEntity.setBarcode("P7988000122");
        deliveryPoint = this.deliveryPointRepository.findByValue(DeliveryPointType.BRANCH.getValue());
        packageEntity.setDeliveryPoint(deliveryPoint);
        packageEntity.setVolumetricWeight(5);
        this.shipmentRepository.save(packageEntity);

        packageEntity = Package.create();
        packageEntity.setBarcode("P7988000123");
        deliveryPoint = this.deliveryPointRepository.findByValue(DeliveryPointType.BRANCH.getValue());
        packageEntity.setDeliveryPoint(deliveryPoint);
        packageEntity.setVolumetricWeight(9);
        this.shipmentRepository.save(packageEntity);

        packageEntity = Package.create();
        packageEntity.setBarcode("P8988000120");
        deliveryPoint = this.deliveryPointRepository.findByValue(DeliveryPointType.DISTRIBUTION_CENTER.getValue());
        packageEntity.setDeliveryPoint(deliveryPoint);
        packageEntity.setVolumetricWeight(33);
        this.shipmentRepository.save(packageEntity);

        packageEntity = Package.create();
        packageEntity.setBarcode("P8988000121");
        deliveryPoint = this.deliveryPointRepository.findByValue(DeliveryPointType.DISTRIBUTION_CENTER.getValue());
        packageEntity.setDeliveryPoint(deliveryPoint);
        packageEntity.setVolumetricWeight(17);
        this.shipmentRepository.save(packageEntity);

        packageEntity = Package.create();
        packageEntity.setBarcode("P8988000122");
        deliveryPoint = this.deliveryPointRepository.findByValue(DeliveryPointType.DISTRIBUTION_CENTER.getValue());
        packageEntity.setDeliveryPoint(deliveryPoint);
        packageEntity.setVolumetricWeight(26);
        this.shipmentRepository.save(packageEntity);

        packageEntity = Package.create();
        packageEntity.setBarcode("P8988000123");
        deliveryPoint = this.deliveryPointRepository.findByValue(DeliveryPointType.DISTRIBUTION_CENTER.getValue());
        packageEntity.setDeliveryPoint(deliveryPoint);
        packageEntity.setVolumetricWeight(35);
        this.shipmentRepository.save(packageEntity);

        packageEntity = Package.create();
        packageEntity.setBarcode("P8988000124");
        deliveryPoint = this.deliveryPointRepository.findByValue(DeliveryPointType.DISTRIBUTION_CENTER.getValue());
        packageEntity.setDeliveryPoint(deliveryPoint);
        packageEntity.setVolumetricWeight(1);
        this.shipmentRepository.save(packageEntity);

        packageEntity = Package.create();
        packageEntity.setBarcode("P8988000125");
        deliveryPoint = this.deliveryPointRepository.findByValue(DeliveryPointType.DISTRIBUTION_CENTER.getValue());
        packageEntity.setDeliveryPoint(deliveryPoint);
        packageEntity.setVolumetricWeight(200);
        this.shipmentRepository.save(packageEntity);

        packageEntity = Package.create();
        packageEntity.setBarcode("P8988000126");
        deliveryPoint = this.deliveryPointRepository.findByValue(DeliveryPointType.DISTRIBUTION_CENTER.getValue());
        packageEntity.setDeliveryPoint(deliveryPoint);
        packageEntity.setVolumetricWeight(50);
        this.shipmentRepository.save(packageEntity);

        packageEntity = Package.create();
        packageEntity.setBarcode("P9988000126");
        deliveryPoint = this.deliveryPointRepository.findByValue(DeliveryPointType.TRANSFER_CENTER.getValue());
        packageEntity.setDeliveryPoint(deliveryPoint);
        packageEntity.setVolumetricWeight(15);
        this.shipmentRepository.save(packageEntity);

        packageEntity = Package.create();
        packageEntity.setBarcode("P9988000127");
        deliveryPoint = this.deliveryPointRepository.findByValue(DeliveryPointType.TRANSFER_CENTER.getValue());
        packageEntity.setDeliveryPoint(deliveryPoint);
        packageEntity.setVolumetricWeight(16);
        this.shipmentRepository.save(packageEntity);

        packageEntity = Package.create();
        packageEntity.setBarcode("P9988000128");
        deliveryPoint = this.deliveryPointRepository.findByValue(DeliveryPointType.TRANSFER_CENTER.getValue());
        packageEntity.setDeliveryPoint(deliveryPoint);
        packageEntity.setVolumetricWeight(55);
        this.shipmentRepository.save(packageEntity);

        packageEntity = Package.create();
        packageEntity.setBarcode("P9988000129");
        deliveryPoint = this.deliveryPointRepository.findByValue(DeliveryPointType.TRANSFER_CENTER.getValue());
        packageEntity.setDeliveryPoint(deliveryPoint);
        packageEntity.setVolumetricWeight(28);
        this.shipmentRepository.save(packageEntity);

        packageEntity = Package.create();
        packageEntity.setBarcode("P9988000130");
        deliveryPoint = this.deliveryPointRepository.findByValue(DeliveryPointType.TRANSFER_CENTER.getValue());
        packageEntity.setDeliveryPoint(deliveryPoint);
        packageEntity.setVolumetricWeight(17);
        this.shipmentRepository.save(packageEntity);
    }
    private void assignPackageToBag(){
        Package packageEntity = (Package) this.shipmentRepository.findByBarcode("P8988000122");
        Bag bag = (Bag) this.shipmentRepository.findByBarcode("C725799");
        packageEntity.loadIntoBag(bag);
        this.shipmentRepository.save(packageEntity);

        packageEntity = (Package) this.shipmentRepository.findByBarcode("P8988000126");
        bag = (Bag) this.shipmentRepository.findByBarcode("C725799");
        packageEntity.loadIntoBag(bag);
        this.shipmentRepository.save(packageEntity);

        packageEntity = (Package) this.shipmentRepository.findByBarcode("P9988000128");
        bag = (Bag) this.shipmentRepository.findByBarcode("C725800");
        packageEntity.loadIntoBag(bag);
        this.shipmentRepository.save(packageEntity);

        packageEntity = (Package) this.shipmentRepository.findByBarcode("P9988000129");
        bag = (Bag) this.shipmentRepository.findByBarcode("C725800");
        packageEntity.loadIntoBag(bag);
        this.shipmentRepository.save(packageEntity);
    }
}
