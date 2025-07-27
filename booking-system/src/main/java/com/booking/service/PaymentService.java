package com.booking.service;

import com.booking.model.Payment;
import com.booking.repository.PaymentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {
    private final PaymentRepository paymentRepository;

    public PaymentService(PaymentRepository paymentRepository){
        this.paymentRepository = paymentRepository;
    }

    public List<Payment> getAllPayments(){
        return paymentRepository.findAll();
    }

    public Payment getPaymendById(Long id){
        return paymentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Payment was not found with id: " + id));
    }

    public Payment createPayment(Payment payment) {
        return paymentRepository.save(payment);
    }

    public Payment getPaymentById(Long id) {
        return paymentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Payment not found with id: " + id));
    }

    public void deletePaymentById(Long id) {
        paymentRepository.deleteById(id);
    }
}
