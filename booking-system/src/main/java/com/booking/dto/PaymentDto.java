package com.booking.dto;

import com.booking.model.PaymentMethod;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PaymentDto {

    private Long id;
    private BookingDto booking;
    private PaymentMethod paymentMethod;
    private double amount;
    private Date paymentDate;
    private boolean paymentStatus;
}
