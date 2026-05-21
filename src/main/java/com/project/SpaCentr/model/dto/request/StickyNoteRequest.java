package com.project.SpaCentr.model.dto.request;

import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record StickyNoteRequest(LocalDate date,@Size(max = 2000) String text) {

}
