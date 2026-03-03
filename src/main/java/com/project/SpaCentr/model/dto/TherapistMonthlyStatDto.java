package com.project.SpaCentr.model.dto;

public record TherapistMonthlyStatDto(Long id,
                                      String therapistName,
                                      int year,
                                      int month,
                                      long completedCount,
                                      double totalAmount) {
}
