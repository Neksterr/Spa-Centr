package com.project.SpaCentr.model.dto.request;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateSpaServiceRequest(@NotBlank String spaService,
                                      @NotNull int duration,
                                      @NotNull @DecimalMin("0.00") double price) {
}
