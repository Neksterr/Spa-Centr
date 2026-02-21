package com.project.SpaCentr.model.entity;

import java.time.LocalDate;

public class AvailabilitySlotEntity extends BaseEntity {
    private TherapistEntity therapistId;
    private LocalDate dayOfWeek;
    private int slotStartTime;
    private int slotEndTime;
    private boolean isAvailable;
}
