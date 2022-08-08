package com.sql.carcaresystem.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "services")
public class Service {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "servicesID")
    private Integer serviceID;
    @Column(name = "servicesName")
    private String serviceName;
    @Column(name = "servicesPrice")
    private float servicePrice;
    @Column(name = "servicesDetails")
    private String serviceDetails;

    public Integer getServiceID() {
        return serviceID;
    }

    public void setServiceID(Integer serviceID) {
        this.serviceID = serviceID;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public float getServicePrice() {
        return servicePrice;
    }

    public void setServicePrice(float servicePrice) {
        this.servicePrice = servicePrice;
    }

    public String getServiceDetails() {
        return serviceDetails;
    }

    public void setServiceDetails(String serviceDetails) {
        this.serviceDetails = serviceDetails;
    }

}
