package com.project.SpaCentr.model.dto;

import com.project.SpaCentr.model.enums.Role;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateEmployeeDto(@NotBlank String username, @NotBlank String fullName, @NotNull Role role, @NotBlank String password) {

}
