package com.project.SpaCentr.model.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class BookingDTO {
    private Long therapistId;
    private Long serviceId;
    private LocalDateTime bookingStartDateTime;
    private String clientName;
    private String clientPhoneNumber;
    private String bookingStatus;

    public BookingDTO() {
    }

    public Long getTherapistId() {
        return therapistId;
    }

    public void setTherapistId(Long therapistId) {
        this.therapistId = therapistId;
    }

    public Long getServiceId() {
        return serviceId;
    }

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }

    public LocalDateTime getBookingStartDateTime() {
        return bookingStartDateTime;
    }

    public void setBookingStartDateTime(LocalDateTime bookingStartDateTime) {
        this.bookingStartDateTime = bookingStartDateTime;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientPhoneNumber() {
        return clientPhoneNumber;
    }

    public void setClientPhoneNumber(String clientPhoneNumber) {
        this.clientPhoneNumber = clientPhoneNumber;
    }

    public String getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(String bookingStatus) {
        this.bookingStatus = bookingStatus;
    }
}
