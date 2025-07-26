package com.booking.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String roomNumber;
    String description;
    int capacity;
    double pricePerNight;
    boolean available;
    @OneToMany(mappedBy = "room")
    List<Booking> bookings;
}
