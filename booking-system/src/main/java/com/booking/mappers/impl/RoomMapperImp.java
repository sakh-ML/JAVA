package com.booking.mappers.impl;

import com.booking.dto.BookingDto;
import com.booking.dto.RoomDto;
import com.booking.mappers.BookingMapper;
import com.booking.mappers.RoomMapper;
import com.booking.model.Booking;
import com.booking.model.Room;
import org.hibernate.annotations.Comment;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RoomMapperImp implements RoomMapper {

    private final BookingMapper bookingMapper;

    public RoomMapperImp(BookingMapper bookingMapper) {
        this.bookingMapper = bookingMapper;
    }


    @Override
    public Room toRoom(RoomDto roomDto) {

        List<Booking> rooms = roomDto.getBookings() == null ? null :
                roomDto.getBookings().stream().map(bookingMapper::toBooking).toList();

        return new Room(
                roomDto.getId(), roomDto.getRoomNumber(), roomDto.getDescription(),
                roomDto.getCapacity(), roomDto.getPricePerNight(), roomDto.isAvailable(), rooms
        );
    }

    @Override
    public RoomDto toRoomDto(Room room) {

        List<BookingDto> bookingsDto = room.getBookings() == null ? null :
                room.getBookings().stream().map(bookingMapper::toBookingDto).toList();

        return new RoomDto(
                room.getId(), room.getRoomNumber(), room.getDescription(), room.getCapacity(),
                room.getPricePerNight(), room.isAvailable(), bookingsDto
        );
    }
}
