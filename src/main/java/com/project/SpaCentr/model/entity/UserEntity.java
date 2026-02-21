package com.project.SpaCentr.model.entity;

import com.project.SpaCentr.model.enums.Role;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "users")
public class UserEntity extends BaseEntity {
    @Column(name = "usernames",nullable = false,unique = true)
    private String username;
    @Column(name = "passwords",nullable = false)
    private String password;
    @Enumerated(EnumType.STRING)
    @Column(name = "roles",nullable = false)
    private Role role;
    @Column(name = "enabled",nullable = false)
    private boolean enabled;
    @Column(name = "created_date",nullable = false)
    private LocalDate createdDate;
    @Column(name = "last_modified_date",nullable = false)
    private LocalDate lastModifiedDate;


    public UserEntity() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDate getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(LocalDate lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }
}
