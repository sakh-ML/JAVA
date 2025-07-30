package com.booking.mappers;

import com.booking.dto.BookingDto;
import com.booking.model.Booking;

public interface BookingMapper {

    Booking toBooking(BookingDto bookingDto);
    BookingDto toBookingDto(Booking booking);
}
