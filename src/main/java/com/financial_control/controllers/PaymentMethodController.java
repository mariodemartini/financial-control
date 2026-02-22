package com.financial_control.controllers;

import com.financial_control.dtos.requests.PaymentMethodRequestDTO;
import com.financial_control.dtos.responses.PaymentMethodResponseDTO;
import com.financial_control.services.PaymentMethodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payment-methods")
public class PaymentMethodController {

    @Autowired
    private PaymentMethodService paymentMethodService;

    @GetMapping
    public List<PaymentMethodResponseDTO> findAllPaymentMethod() {
        return paymentMethodService.findAllPaymentMethods();
    }

    @GetMapping("/payment-method/{id}")
    public PaymentMethodResponseDTO findPaymentMethodById(@PathVariable Long id) {
        return paymentMethodService.findPaymentMethodById(id);
    }

    @PostMapping
    public PaymentMethodResponseDTO createPaymentMethod(@RequestBody PaymentMethodRequestDTO paymentMethodRequestDTO) {
        return paymentMethodService.createPaymentMethod(paymentMethodRequestDTO);
    }

    @PutMapping("/payment-method/{id}")
    public PaymentMethodResponseDTO updatePaymentMethod(@PathVariable Long id,
                                                        @RequestBody PaymentMethodRequestDTO paymentMethodRequestDTO) {
        return paymentMethodService.updatePaymentMethod(id, paymentMethodRequestDTO);
    }

    @DeleteMapping("/payment-method/{id}")
    public void deletePaymentMethod(@PathVariable Long id) {
        paymentMethodService.deletePaymentMethod(id);
    }

}

