package com.booking.mappers;


import com.booking.dto.RoomDto;
import com.booking.model.Room;

public interface RoomMapper {
    Room toRoom(RoomDto roomDto);
    RoomDto toRoomDto(Room room);
}
