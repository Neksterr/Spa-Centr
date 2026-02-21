package com.project.SpaCentr.model.entity;

import com.project.SpaCentr.model.enums.Role;

import java.time.LocalDate;

public class UserEntity extends BaseEntity {
    private String username;
    private String password;
    private Role role;
    private boolean enabled;
    private LocalDate createdDate;
    private LocalDate lastModifiedDate;
}
