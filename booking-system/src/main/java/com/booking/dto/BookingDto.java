package com.booking.dto;

import com.booking.model.BookingStatus;
import com.booking.model.Payment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDate;
import java.util.Date;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class BookingDto {

    private Long id;
    private UserDto user;
    private RoomDto room;
    private LocalDate startDate;
    private LocalDate endDate;
    private double totalPrice;
    private BookingStatus status;
    private Date createdAt;
    private Date updatedAt;
    private Payment payment;
}
