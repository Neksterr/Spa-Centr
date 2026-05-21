package com.project.SpaCentr.service;

import com.project.SpaCentr.model.dto.response.BookingResponse;
import com.project.SpaCentr.model.dto.request.CreateBookingRequest;
import com.project.SpaCentr.model.entity.BookingEntity;
import com.project.SpaCentr.model.entity.Employee;
import com.project.SpaCentr.model.entity.SpaServiceEntity;
import com.project.SpaCentr.model.enums.BookingStatus;
import com.project.SpaCentr.model.enums.Role;
import com.project.SpaCentr.repository.BookingRepository;
import com.project.SpaCentr.repository.EmployeeRepository;
import com.project.SpaCentr.security.CurrentUser;
import com.project.SpaCentr.security.EmployeePrincipal;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;

import static org.springframework.http.HttpStatus.*;

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

        EmployeePrincipal me = CurrentUser.principal();
        if (me.getRole() != Role.RECEPTIONIST){
            throw new ResponseStatusException(FORBIDDEN,"YOU DON'T HAVE AUTHORITY");
        }
        SpaServiceEntity spaService = spaServicesService.getActiveOrThrow(createBookingRequest.spaServiceId());
        Employee therapist = employeeRepository.findById(createBookingRequest.therapistId())
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND,"Therapist not found"));
        LocalDateTime start = createBookingRequest.startTime();
        LocalDateTime end = start.plusMinutes(spaService.getDurationMinutes());
        boolean overlap = bookingRepository.existsOverLappingSchedule(therapist.getId(),start,end);
        if (overlap){
            throw new ResponseStatusException(CONFLICT,"Therapist is unavailable");

        }
        Employee createdBy = employeeRepository.findById(CurrentUser.id()).orElseThrow(() -> new ResponseStatusException(UNAUTHORIZED,"Creator not found"));
        BookingEntity booking = modelMapper.map(createBookingRequest,BookingEntity.class);
        booking.setSpaServiceId(spaService);
        booking.setTherapistId(therapist);
        booking.setCreatedBy(createdBy);
        booking.setEndTime(end);
        booking.setBookingStatus(BookingStatus.BOOKED);
        bookingRepository.save(booking);

        return modelMapper.map(booking, BookingResponse.class);
    }
    public BookingResponse completedBooking(long bookingId){
        EmployeePrincipal me = CurrentUser.principal();
        if(me.getRole() != Role.THERAPIST){
            throw new ResponseStatusException(FORBIDDEN,"Only therapist");
        }
        BookingEntity booking = (BookingEntity) bookingRepository.findBookingById(bookingId).orElseThrow(() -> new ResponseStatusException(NOT_FOUND,"Booking not found"));
        if (booking.getBookingStatus() != BookingStatus.BOOKED) {
            throw new ResponseStatusException(CONFLICT, "Only scheduled bookings can be completed");
        }
        booking.setBookingStatus(BookingStatus.COMPLETED);
        booking.setCompletedAt(Instant.now());
        bookingRepository.save(booking);
        return modelMapper.map(booking,BookingResponse.class);
    }
    public List<BookingResponse> listAllBookings(LocalDateTime from, LocalDateTime to){
        return bookingRepository.findAllByStartTimeAndEndTimePeriod(from,to).stream()
                .map(book -> modelMapper.map(book,BookingResponse.class)).toList();
    }
    public  BookingResponse cancelBooking(long bookingId){
        EmployeePrincipal me = CurrentUser.principal();
        if(me.getRole() != Role.RECEPTIONIST){
            throw new ResponseStatusException(FORBIDDEN,"YOU DON'T HAVE THE AUTHORITY");
        }
        BookingEntity booking = (BookingEntity) bookingRepository.findBookingById(bookingId).orElseThrow(() -> new ResponseStatusException(NOT_FOUND,"Booking not found"));
        if(booking.getBookingStatus() == BookingStatus.COMPLETED){
            throw new ResponseStatusException(CONFLICT,"It's already completed");
        }
        booking.setBookingStatus(BookingStatus.CANCELLED);
        bookingRepository.save(booking);
        return modelMapper.map(booking,BookingResponse.class);


    }
}

