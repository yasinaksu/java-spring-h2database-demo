package com.fleetmanagament.entity.domain;

import javax.persistence.*;

@Entity
@Table(name = "delivery_points")
public class DeliveryPoint {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(name = "value_code")
    private Integer value;

    protected DeliveryPoint() {

    }

    public Long getId() {
        return id;
    }

    public DeliveryPoint setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public DeliveryPoint setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getValue() {
        return value;
    }

    public DeliveryPoint setValue(Integer value) {
        this.value = value;
        return this;
    }

    public static DeliveryPoint create(){
        return new DeliveryPoint();
    }
}
