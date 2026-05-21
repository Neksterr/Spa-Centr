package com.project.SpaCentr.model.dto.response;

import java.time.Instant;
import java.time.LocalDate;

public record StickyNoteResponse(LocalDate date, String text, String updatedByEmployee, Instant updatedAt) {
}
