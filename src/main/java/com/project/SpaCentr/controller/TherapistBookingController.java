package com.project.SpaCentr.controller;

import com.project.SpaCentr.model.dto.BookingResponse;
import com.project.SpaCentr.service.BookingService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/therapist/bookings")
public class TherapistBookingController {
    private final BookingService bookingService;

    public TherapistBookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }
    @GetMapping
    public List<BookingResponse> listOfBookingsForPeriod(@RequestParam LocalDateTime from, LocalDateTime to){
        return bookingService.listAllBookings(from,to);
    }
    @PatchMapping("/{id}/complete")
    public BookingResponse comleteBooking(@PathVariable long id){
        return bookingService.completedBooking(id);
    }

    //show list of completed for period
    //show list of canceled for period
}
