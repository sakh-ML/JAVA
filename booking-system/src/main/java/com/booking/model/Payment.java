package com.booking.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @OneToOne(mappedBy = "payment")
    Booking booking;
    @Enumerated(EnumType.STRING)
    PaymentMethod paymentMethod;
    double amount;
    Date paymentDate;
    boolean paymentStatus;
}
