package com.project.SpaCentr.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "therapists")
public class TherapistEntity extends BaseEntity{
    @OneToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity userId;
    @Column(name = "therapist_name",nullable = false)
    private String fullName;
    @Column(name = "phone_number", nullable = false, unique = true)
    private int phoneNumber;


    public TherapistEntity(UserEntity userId, String fullName, int phoneNumber) {
        this.userId = userId;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
    }

    public UserEntity getUserId() {
        return userId;
    }

    public void setUserId(UserEntity userId) {
        this.userId = userId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
