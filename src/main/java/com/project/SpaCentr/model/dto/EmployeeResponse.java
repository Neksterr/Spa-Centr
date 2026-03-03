package com.project.SpaCentr.model.dto;

import com.project.SpaCentr.model.enums.Role;

public record EmployeeResponse(Long id,
                               String username,
                               String fullName,
                               Role role,
                               boolean enable) {
}
