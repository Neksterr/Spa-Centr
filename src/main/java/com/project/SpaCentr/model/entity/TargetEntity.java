package com.project.SpaCentr.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "targets")
public class TargetEntity extends BaseEntity {

    private TherapistEntity therapistId;
    @Column(name = "year_range",nullable = false)
    private LocalDate year;
    @Column(name = "month_range", nullable = false)
    private LocalDate month;
 //   @Column(name = "target_count")
    private int targetCount;
    private double targetRevenue;

}
