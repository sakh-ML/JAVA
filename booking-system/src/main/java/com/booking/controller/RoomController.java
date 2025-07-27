package com.booking.controller;

import com.booking.model.Room;
import com.booking.service.RoomService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RoomController {

    private final RoomService roomService;

    public RoomController(RoomService roomService){
        this.roomService = roomService;
    }

    @GetMapping("/rooms")
    public List<Room> getRooms(){
        return roomService.getRooms();
    }

    @GetMapping("/rooms/{id}")
    public Room getRoom(@PathVariable long id){
        return roomService.getRoomById(id);
    }

    @PostMapping("/rooms")
    public Room addRoom(@RequestBody Room room){
        return roomService.createRoom(room);
    }

    @PutMapping("/rooms/{id}")
    public Room updateRoom(@PathVariable long id, @RequestBody Room room){
        return roomService.update(id, room);
    }

    @DeleteMapping("/rooms/{id}")
    public void deleteRoom(@PathVariable long id){
        roomService.deleteRoomById(id);
    }
}
