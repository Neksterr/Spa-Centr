package com.project.SpaCentr.model.dto.response;

import com.project.SpaCentr.model.enums.BookingStatus;

import java.time.LocalDateTime;

public record BookingResponse(Long id,
                              String clientName,
                              String clientPhone,
                              Long spaServiceId,
                              String spaService,
                              Long therapistId,
                              String therapistName,
                              LocalDateTime startTime,
                              BookingStatus status,
                              String note) {
}
