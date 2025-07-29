package com.booking.mappers.impl;

import com.booking.dto.BookingDto;
import com.booking.dto.UserDto;
import com.booking.mappers.UserMapper;
import com.booking.model.Booking;
import com.booking.model.User;

import java.util.List;
import java.util.stream.Collectors;

public class UserMapperImpl implements UserMapper {

    @Override
    public User toUser(UserDto user) {
        List<Booking> bookings = UserDto.getUserBookings() == null ? null :
                UserDto.getUserBookings()
                        .stream()
                        .map(BookingMapper::toBooking)
                        .collect(Collectors.toList());

        return new User(user.getId(), user.getUsername(), user.getEmail(), user.getPassword(), user.getRole(),
                user.getFullName(), user.getPhoneNumber(), user.getCreatedAt(), user.getUpdatedAt(), user.getUserBookings());
    }

    @Override
    public UserDto toDto(User user) {
        List<BookingDto> bookingDtos = user.getUserBookings() == null ? null :
                user.getUserBookings()
                        .stream()
                        .map(BookingMapper::toDto)
                        .collect(Collectors.toList());

        return new UserDto(user.getId(), user.getUsername(), user.getEmail(), user.getPassword(), user.getRole(),
                user.getFullName(), user.getPhoneNumber(), user.getCreatedAt(), user.getUpdatedAt(), user.getUserBookings());
    }
}
