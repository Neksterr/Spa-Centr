package com.project.SpaCentr.model.dto.response;

public record SpaServiceResponse(Long id,
                                 String spaService,
                                 int duration,
                                 double price) {
}
