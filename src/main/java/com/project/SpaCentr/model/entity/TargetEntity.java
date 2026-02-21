package com.project.SpaCentr.model.entity;

import java.time.LocalDate;

public class TargetEntity extends BaseEntity {
    private TherapistEntity therapistId;
    private LocalDate year;
    private LocalDate month;
    private int targetCount;
    private double targetRevenue;

}
