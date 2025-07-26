package com.booking.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    User user;
    Room room;
    LocalDate startDate;
    LocalDate endDate;
    double totalPrice;
    @Enumerated(EnumType.STRING)
    BookingStatus status;
    Date createdAt;
    Date updatedAt;
}
