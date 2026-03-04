package com.project.SpaCentr.service;

import com.project.SpaCentr.model.dto.BookingResponse;
import com.project.SpaCentr.model.dto.CreateBookingRequest;
import com.project.SpaCentr.model.entity.BookingEntity;
import com.project.SpaCentr.repository.BookingRepository;
import com.project.SpaCentr.repository.EmployeeRepository;
import com.project.SpaCentr.repository.SpaServiceRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class BookingService {
    private final BookingRepository bookingRepository;
    private final SpaServicesService spaServicesService;
    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;

    public BookingService(BookingRepository bookingRepository, SpaServicesService spaServicesService, EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.bookingRepository = bookingRepository;
        this.spaServicesService = spaServicesService;
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }


    public BookingResponse create(CreateBookingRequest createBookingRequest){
        BookingEntity newBooking = modelMapper.map(createBookingRequest,BookingEntity.class);

        return modelMapper.map(newBooking, BookingResponse.class);
    }
}
