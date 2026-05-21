package com.project.SpaCentr.model.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record CreateBookingRequest(@NotBlank String clientName,
                                   @NotBlank String phone,
                                   @NotNull Long spaServiceId,
                                   @NotNull Long therapistId,
                                   @NotNull LocalDateTime startTime,
                                   String note) {
}
