package com.booking.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserDto {

    private Long id;
    private String username;
    private String email;
    private String password;
    private String role;
    private String fullName;
    private String phoneNumber;
    private Date createdAt;
    private Date updatedAt;
    private List<BookingDto> userBookings;
}
