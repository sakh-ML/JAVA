package com.booking.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class RoomDto {


    private long id;
    private String roomNumber;
    private String description;
    private int capacity;
    private double pricePerNight;
    private boolean available;
    private List<BookingDto> bookings;
}
