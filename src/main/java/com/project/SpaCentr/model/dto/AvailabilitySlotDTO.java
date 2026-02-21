package com.project.SpaCentr.model.dto;

import jakarta.persistence.Column;

import java.time.LocalDate;

public class AvailabilitySlotDTO {
    private Long id;
    private Long therapistId;
    private LocalDate dayOfWeek;
    private int slotStartTime;
    private int slotEndTime;
    private boolean isAvailable = true;

    public AvailabilitySlotDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTherapistId() {
        return therapistId;
    }

    public void setTherapistId(Long therapistId) {
        this.therapistId = therapistId;
    }

    public LocalDate getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(LocalDate dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public int getSlotStartTime() {
        return slotStartTime;
    }

    public void setSlotStartTime(int slotStartTime) {
        this.slotStartTime = slotStartTime;
    }

    public int getSlotEndTime() {
        return slotEndTime;
    }

    public void setSlotEndTime(int slotEndTime) {
        this.slotEndTime = slotEndTime;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
