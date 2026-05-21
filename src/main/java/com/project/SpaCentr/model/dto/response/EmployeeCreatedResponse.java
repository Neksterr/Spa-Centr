package com.project.SpaCentr.model.dto.response;

import com.project.SpaCentr.model.enums.Role;

public record EmployeeCreatedResponse(Long id, String username,
                                      String fullName,
                                      Role role,
                                      boolean enable,
                                      String password) {
}
