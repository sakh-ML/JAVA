package com.booking.mappers.impl;

import com.booking.dto.PaymentDto;
import com.booking.mappers.PaymentMapper;
import com.booking.model.Payment;
import org.springframework.stereotype.Component;


@Component
public class PaymentMapperImp implements PaymentMapper {
    @Override
    public Payment toPayment(PaymentDto paymentDto) {
        return null;
    }

    @Override
    public PaymentDto toPaymentDto(Payment Payment) {
        return null;
    }
}
