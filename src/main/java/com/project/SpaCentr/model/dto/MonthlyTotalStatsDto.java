package com.project.SpaCentr.model.dto;

public record MonthlyTotalStatsDto(int year,
                                   int month,
                                   long completedCount,
                                   double totalAmount) {
}
