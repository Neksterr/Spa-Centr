package com.project.SpaCentr.model.entity;

import com.project.SpaCentr.model.enums.BookingStatus;

import java.time.LocalDate;

public class BookingEntity extends BaseEntity{
    private TherapistEntity therapistId;
    private SpaServiceEntity spaServiceId;
    private LocalDate bookingDate;
    private String clientName;
    private String clientPhoneNumber;
    private BookingStatus bookingStatus;
    private UserEntity createdByUserId;
}
