package com.booking.controller;

import com.booking.model.Booking;
import com.booking.service.BookingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookingController {

    final private BookingService bookingService;

    public BookingController(BookingService bookingService){
        this.bookingService = bookingService;
    }

    @GetMapping("/bookings")
    public List<Booking> getBookings(){
        return bookingService.getAllBookings();
    }

    @GetMapping("/bookings/{id}")
    public Booking getBooking(@PathVariable long id){
        return bookingService.getBookingById(id);
    }

    @PostMapping("/bookings")
    public Booking addBooking(@RequestBody Booking booking){
        return bookingService.createBooking(booking);
    }

    @PutMapping("/bookings/{id}")
    public Booking updateBooking(@PathVariable long id, @RequestBody Booking booking){
        return bookingService.updateBooking(id, booking);
    }

    @DeleteMapping("/bookings/{id}")
    public void deleteBooking(@PathVariable long id){
        bookingService.deleteBookingById(id);
    }

}
