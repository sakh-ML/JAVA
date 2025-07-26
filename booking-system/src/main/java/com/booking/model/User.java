package com.booking.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

//@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String username;
    String email;
    String password;
    String role;
    String fullName;
    String phoneNumber;
    Date createdAt;
    Date updatedAt;
    @OneToMany(mappedBy = "user")
    List<Booking> userBookings;
}
