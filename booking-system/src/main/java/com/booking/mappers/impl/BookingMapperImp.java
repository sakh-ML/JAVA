package com.booking.mappers.impl;

import com.booking.dto.BookingDto;
import com.booking.mappers.BookingMapper;
import com.booking.mappers.PaymentMapper;
import com.booking.mappers.RoomMapper;
import com.booking.mappers.UserMapper;
import com.booking.model.Booking;
import org.springframework.stereotype.Component;


@Component
public class BookingMapperImp implements BookingMapper {

    private final RoomMapper roomMapper;
    private final UserMapper userMapper;
    private final PaymentMapper paymentMapper;

    public BookingMapperImp(RoomMapper roomMapper, UserMapper userMapper, PaymentMapper paymentMapper) {
        this.roomMapper = roomMapper;
        this.userMapper = userMapper;
        this.paymentMapper = paymentMapper;
    }



    public Booking toBooking(BookingDto bookingDto) {
        return new Booking(bookingDto.getId(), userMapper.toUser(bookingDto.getUser()),
                roomMapper.toRoom(bookingDto.getRoom()),
                bookingDto.getStartDate(), bookingDto.getEndDate(), bookingDto.getTotalPrice(),
                bookingDto.getStatus(), bookingDto.getCreatedAt(), bookingDto.getUpdatedAt(),
                paymentMapper.toPayment(bookingDto.getPayment()));
    }

    @Override
    public BookingDto toBookingDto(Booking booking) {
        return new BookingDto(
                booking.getId(),userMapper.toDto(booking.getUser()),roomMapper.toRoomDto(booking.getRoom()),
                booking.getStartDate(), booking.getEndDate(), booking.getTotalPrice(),
                booking.getStatus(), booking.getCreatedAt(), booking.getUpdatedAt(),
                paymentMapper.toPaymentDto(booking.getPayment())
        );
    }
}
