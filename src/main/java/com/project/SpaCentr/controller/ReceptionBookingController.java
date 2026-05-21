package com.project.SpaCentr.controller;

import com.project.SpaCentr.model.dto.response.BookingResponse;
import com.project.SpaCentr.model.dto.request.CreateBookingRequest;
import com.project.SpaCentr.service.BookingService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/reception/bookings")
public class ReceptionBookingController {
    private final BookingService bookingService;

    public ReceptionBookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping
    public BookingResponse createBooking(@Valid @RequestBody CreateBookingRequest createBookingRequest){
        return  bookingService.create(createBookingRequest);
    }
    @PatchMapping("/{id}/cancel")
    public BookingResponse cancelBooking(@PathVariable long id){
        return bookingService.cancelBooking(id);

    }
    @GetMapping
    public List<BookingResponse> listOfBookings(@RequestParam LocalDateTime from, LocalDateTime to){
        return  bookingService.listAllBookings(from,to);
    }

    //create and update method for changing services,phone,name and etc
}
