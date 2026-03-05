package com.project.SpaCentr.model.entity;

import com.project.SpaCentr.model.enums.BookingStatus;
import jakarta.persistence.*;

import java.time.Instant;
import java.time.LocalDateTime;

@Entity
@Table(name = "bookings")
public class BookingEntity extends BaseEntity{
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "therapist_id", nullable = false)
    private Employee therapistId;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "spa_service_id", nullable = false)
    private SpaServiceEntity spaServiceId;
    @ManyToOne(optional = false,fetch = FetchType.LAZY)
    @JoinColumn(name = "created_by_id",nullable = false,foreignKey = @ForeignKey(name = "fk_booking_created_by"))
    private Employee createdBy;

    @Column(name = "booking_start_date_time", nullable = false)
    private LocalDateTime bookingStartDateTime;
    @Column(name = "booking_end_date_time", nullable = false)
    private LocalDateTime bookingEndDateTime;

    @Column(name = "client_name", nullable = false)
    private String clientName;
    @Column(name = "client_phone_number", nullable = false)
    private String clientPhoneNumber;
    @Enumerated(EnumType.STRING)
    @Column(name = "booking_status", nullable = false)
    private BookingStatus bookingStatus = BookingStatus.BOOKED;
    @Column(name = "notes",length = 400)
    private String note;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "created_by_user_id",nullable = false)
    private Employee createdByUserId;
    @Column(name = "created_at", nullable = false,updatable = false)
    private Instant createdAt;
    private Instant completedAt;

    public BookingEntity() {
    }

    public Employee getTherapistId() {
        return therapistId;
    }

    public void setTherapistId(Employee therapistId) {
        this.therapistId = therapistId;
    }

    public SpaServiceEntity getSpaServiceId() {
        return spaServiceId;
    }

    public void setSpaServiceId(SpaServiceEntity spaServiceId) {
        this.spaServiceId = spaServiceId;
    }

    public Employee getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Employee createdBy) {
        this.createdBy = createdBy;
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

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Employee getCreatedByUserId() {
        return createdByUserId;
    }

    public void setCreatedByUserId(Employee createdByUserId) {
        this.createdByUserId = createdByUserId;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Instant getCompletedAt() {
        return completedAt;
    }

    public void setCompletedAt(Instant completedAt) {
        this.completedAt = completedAt;
    }

    public void setEndTime(LocalDateTime end) {
    }
}
