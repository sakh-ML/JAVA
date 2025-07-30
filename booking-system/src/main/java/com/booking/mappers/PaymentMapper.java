package com.booking.mappers;

import com.booking.dto.PaymentDto;
import com.booking.model.Payment;

public interface PaymentMapper {
    Payment toPayment(PaymentDto paymentDto);
    PaymentDto toPaymentDto(Payment Payment);
}
