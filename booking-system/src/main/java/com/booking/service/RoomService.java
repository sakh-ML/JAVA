package com.booking.service;

import com.booking.model.Room;
import com.booking.repository.RoomRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomService {
    private final RoomRepository roomRepository;

    public RoomService(RoomRepository roomRepository){
        this.roomRepository = roomRepository;
    }

    public List<Room> getRooms(){
        return roomRepository.findAll();
    }

    public Room getRoomById(Long id){
        return roomRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Room not found with id: " + id));

    }

    public Room update(Long id, Room room){
        Optional<Room> optionalRoom = roomRepository.findById(id);
        if(optionalRoom.isPresent()){
            Room existingRoom = optionalRoom.get();
            existingRoom.setRoomNumber(room.getRoomNumber());
            existingRoom.setBookings(room.getBookings());
            existingRoom.setAvailable(room.isAvailable());
            existingRoom.setCapacity(room.getCapacity());
            existingRoom.setBookings(room.getBookings());
            existingRoom.setPricePerNight(room.getPricePerNight());
            return roomRepository.save(existingRoom);
        }
        else{
            throw new RuntimeException("Room not found with id: " + id);
        }
    }

    public Room createRoom(Room room){
        return roomRepository.save(room);
    }

    public void deleteRoomById(Long id){
        roomRepository.deleteById(id);
    }
}
