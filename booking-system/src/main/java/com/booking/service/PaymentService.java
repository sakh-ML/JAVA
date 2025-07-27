package com.booking.service;

import com.booking.model.Payment;
import com.booking.repository.PaymentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Payment updatePayment(long id, Payment payment){
        Optional<Payment> optionalUpdate = paymentRepository.findById(id);
        if(optionalUpdate.isPresent()){
            Payment existingPayment = optionalUpdate.get();
            existingPayment.setPaymentDate(payment.getPaymentDate());
            existingPayment.setPaymentMethod(payment.getPaymentMethod());
            existingPayment.setAmount(payment.getAmount());
            existingPayment.setBooking(payment.getBooking());
            return paymentRepository.save(existingPayment);
        }
        else{
            throw new RuntimeException("Payment was not found with id: " + id);
        }
    }

    public Payment getPaymentById(Long id) {
        return paymentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Payment not found with id: " + id));
    }

    public void deletePaymentById(Long id) {
        paymentRepository.deleteById(id);
    }
}
