package com.project.SpaCentr.model.dto.response;

import com.project.SpaCentr.model.dto.TherapistScheduleDto;

import java.time.LocalDate;
import java.util.List;

public record DashboardResponse(LocalDate date, String view, Integer hour, List<TherapistScheduleDto> therapistScheduleList) {
}
