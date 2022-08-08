package com.fleetmanagament.core.logging;

import javax.persistence.*;

@Entity
@Table(name = "logs")
public class Log {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String message;
    private String barcode;

    public Long getId() {
        return id;
    }

    public Log setId(Long id) {
        this.id = id;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public Log setMessage(String message) {
        this.message = message;
        return this;
    }

    public String getBarcode() {
        return barcode;
    }

    public Log setBarcode(String barcode) {
        this.barcode = barcode;
        return this;
    }
}
