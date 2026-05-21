package com.project.SpaCentr.model.dto;

import com.project.SpaCentr.model.dto.response.BookingMiniResponse;

import java.util.List;

public record TherapistScheduleDto(Long therapistId, String therapistName, List<BookingMiniResponse> therapistBookings) {
}
