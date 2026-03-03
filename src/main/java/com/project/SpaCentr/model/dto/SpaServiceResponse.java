package com.project.SpaCentr.model.dto;

public record SpaServiceResponse(Long id,
                                 String spaService,
                                 int duration,
                                 double price,
                                 boolean active) {
}
