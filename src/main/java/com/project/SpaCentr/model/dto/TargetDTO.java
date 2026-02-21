package com.project.SpaCentr.model.dto;



public class TargetDTO {
    private Long therapistId;
    private int year;
    private int month;
    private Integer targetCount;
    private double targetRevenue;

    public TargetDTO() {
    }

    public Long getTherapistId() {
        return therapistId;
    }

    public void setTherapistId(Long therapistId) {
        this.therapistId = therapistId;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public Integer getTargetCount() {
        return targetCount;
    }

    public void setTargetCount(Integer targetCount) {
        this.targetCount = targetCount;
    }

    public double getTargetRevenue() {
        return targetRevenue;
    }

    public void setTargetRevenue(double targetRevenue) {
        this.targetRevenue = targetRevenue;
    }
}
