package com.project.SpaCentr.model.entity;

import com.project.SpaCentr.model.enums.BookingStatus;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "bookings")
public class BookingEntity extends BaseEntity{
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "therapist_id", nullable = false)
    private TherapistEntity therapistId;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "spa_service_id", nullable = false)
    private SpaServiceEntity spaServiceId;
    @Column(name = "booking_start_date_time", nullable = false)
    private LocalDateTime bookingStartDateTime;

    @Column(name = "client_name", nullable = false)
    private String clientName;
    @Column(name = "client_phone_number", nullable = false)
    private String clientPhoneNumber;
    @Enumerated(EnumType.STRING)
    @Column(name = "booking_status", nullable = false)
    private BookingStatus bookingStatus;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "created_by_user_id",nullable = false)
    private UserEntity createdByUserId;

    public BookingEntity() {
    }

    public TherapistEntity getTherapistId() {
        return therapistId;
    }

    public void setTherapistId(TherapistEntity therapistId) {
        this.therapistId = therapistId;
    }

    public SpaServiceEntity getSpaServiceId() {
        return spaServiceId;
    }

    public void setSpaServiceId(SpaServiceEntity spaServiceId) {
        this.spaServiceId = spaServiceId;
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

    public BookingStatus getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(BookingStatus bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    public UserEntity getCreatedByUserId() {
        return createdByUserId;
    }

    public void setCreatedByUserId(UserEntity createdByUserId) {
        this.createdByUserId = createdByUserId;
    }
}
