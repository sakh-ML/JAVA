package com.booking.mappers.impl;

import com.booking.dto.BookingDto;
import com.booking.dto.UserDto;
import com.booking.mappers.BookingMapper;
import com.booking.mappers.UserMapper;
import com.booking.model.Booking;
import com.booking.model.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;


@Component
public class UserMapperImpl implements UserMapper {

    private final BookingMapper bookingMapper;

    public UserMapperImpl(BookingMapper bookingMapper) {
        this.bookingMapper = bookingMapper;
    }

    @Override
    public User toUser(UserDto user) {
        List<Booking> bookings = user.getUserBookings() == null ? null :
                user.getUserBookings()
                        .stream()
                        .map(bookingMapper::toBooking)
                        .collect(Collectors.toList());

        return new User(user.getId(), user.getUsername(), user.getEmail(), user.getPassword(), user.getRole(),
                user.getFullName(), user.getPhoneNumber(), user.getCreatedAt(), user.getUpdatedAt(), bookings);
    }

    @Override
    public UserDto toDto(User user) {
        List<BookingDto> bookingDtos = user.getUserBookings() == null ? null :
                user.getUserBookings()
                        .stream()
                        .map(bookingMapper::toBookingDto)
                        .collect(Collectors.toList());

        return new UserDto(user.getId(), user.getUsername(), user.getEmail(), user.getPassword(), user.getRole(),
                user.getFullName(), user.getPhoneNumber(), user.getCreatedAt(), user.getUpdatedAt(), bookingDtos);
    }
}
