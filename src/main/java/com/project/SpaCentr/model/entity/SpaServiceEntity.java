package com.project.SpaCentr.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "spa_services")
public class SpaServiceEntity extends BaseEntity{
    @Column(name = "service_name",nullable = false)
    private String serviceName;
    @Column(name = "duration_minutes",nullable = false)
    private int durationMinutes;
    @Column(name = "price",nullable = false)
    private double price;
    @Column(name = "status_active",nullable = false)
    private boolean statusActive;

    public SpaServiceEntity() {
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public int getDurationMinutes() {
        return durationMinutes;
    }

    public void setDurationMinutes(int durationMinutes) {
        this.durationMinutes = durationMinutes;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isStatusActive() {
        return statusActive;
    }

    public void setStatusActive(boolean statusActive) {
        this.statusActive = statusActive;
    }
}
