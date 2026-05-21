package com.project.SpaCentr.service;

import com.project.SpaCentr.model.dto.response.DashboardResponse;
import com.project.SpaCentr.repository.BookingRepository;
import com.project.SpaCentr.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
public class DashboardService {
    private final BookingRepository bookingRepository;
    private final EmployeeRepository employeeRepository;

    public DashboardService(BookingRepository bookingRepository, EmployeeRepository employeeRepository) {
        this.bookingRepository = bookingRepository;
        this.employeeRepository = employeeRepository;
    }

    public DashboardResponse dashboard(LocalDate date,String view, Integer hour){
        LocalDateTime from;
        LocalDateTime to;
        
    }
}
