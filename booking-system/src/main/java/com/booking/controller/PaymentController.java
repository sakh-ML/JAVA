package com.booking.controller;

import com.booking.model.Payment;
import com.booking.service.PaymentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PaymentController {

    final private PaymentService paymentService;

    public PaymentController(PaymentService paymentService){
        this.paymentService = paymentService;
    }

    @GetMapping("/payments")
    public List<Payment> getPayments(){
        return paymentService.getAllPayments();
    }

    @GetMapping("/payments/{id}")
    public Payment getPayment(@PathVariable long id){
        return paymentService.getPaymentById(id);
    }

    @PostMapping("/payments")
    public Payment addPayment(@RequestBody Payment payment){
        return paymentService.createPayment(payment);
    }

    @PutMapping("/payments/{id}")
    public Payment updatePayment(@RequestBody Payment payment, @PathVariable long id){
        return paymentService.updatePayment(id, payment);
    }

    @DeleteMapping("/payments/{id}")
    public void deletePayment(@PathVariable long id){
        paymentService.deletePaymentById(id);
    }

}
