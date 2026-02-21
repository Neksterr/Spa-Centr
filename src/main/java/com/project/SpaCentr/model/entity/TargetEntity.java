package com.project.SpaCentr.model.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "targets")
public class TargetEntity extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "therapist_id", nullable = false)
    private TherapistEntity therapistId;

    @Column(name = "year_range",nullable = false)
    private LocalDate year;
    @Column(name = "month_range", nullable = false)
    private LocalDate month;
    @Column(name = "target_count")
    private int targetCount;
    @Column(name = "target_revenue")
    private double targetRevenue;

    public TherapistEntity getTherapistId() {
        return therapistId;
    }

    public void setTherapistId(TherapistEntity therapistId) {
        this.therapistId = therapistId;
    }

    public LocalDate getYear() {
        return year;
    }

    public void setYear(LocalDate year) {
        this.year = year;
    }

    public LocalDate getMonth() {
        return month;
    }

    public void setMonth(LocalDate month) {
        this.month = month;
    }

    public int getTargetCount() {
        return targetCount;
    }

    public void setTargetCount(int targetCount) {
        this.targetCount = targetCount;
    }

    public double getTargetRevenue() {
        return targetRevenue;
    }

    public void setTargetRevenue(double targetRevenue) {
        this.targetRevenue = targetRevenue;
    }
}
