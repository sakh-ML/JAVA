package com.booking.service;

import com.booking.model.Booking;
import com.booking.repository.BookingRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingService {
    private final BookingRepository bookingRepository;

    public BookingService(BookingRepository bookingRepository){
        this.bookingRepository = bookingRepository;
    }

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    public Booking getBookingById(Long id) {
        return bookingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Booking was not found with id: " + id));
    }

    public Booking createBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    public Booking updateBooking(Long id, Booking updatedBooking) {
        return bookingRepository.findById(id).map(existingBooking -> {
            existingBooking.setUser(updatedBooking.getUser());
            existingBooking.setRoom(updatedBooking.getRoom());
            existingBooking.setStartDate(updatedBooking.getStartDate());
            existingBooking.setEndDate(updatedBooking.getEndDate());
            existingBooking.setTotalPrice(updatedBooking.getTotalPrice());
            existingBooking.setStatus(updatedBooking.getStatus());
            existingBooking.setPayment(updatedBooking.getPayment());
            existingBooking.setCreatedAt(updatedBooking.getCreatedAt());
            existingBooking.setUpdatedAt(updatedBooking.getUpdatedAt());
            return bookingRepository.save(existingBooking);
        }).orElseThrow(() -> new RuntimeException("Booking not found with id: " + id));
    }

    public void deleteBookingById(Long id) {
        bookingRepository.deleteById(id);
    }
}
