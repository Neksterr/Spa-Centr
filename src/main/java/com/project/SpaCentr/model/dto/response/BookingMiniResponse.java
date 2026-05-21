package com.project.SpaCentr.model.dto.response;

import com.project.SpaCentr.model.enums.BookingStatus;

import java.time.LocalDateTime;

public  record BookingMiniResponse(Long bookingId,
                                   String serviceName,
                                   String clientName,
                                   String clientPhone,
                                   LocalDateTime startTime,
                                   LocalDateTime endTime,
                                   BookingStatus bookingStatus) {
}
