package com.financial_control.services;

import com.financial_control.dtos.requests.PaymentMethodRequestDTO;
import com.financial_control.dtos.responses.PaymentMethodResponseDTO;

import java.util.List;

public interface PaymentMethodService {

    PaymentMethodResponseDTO createPaymentMethod(PaymentMethodRequestDTO paymentMethodRequestDTO);
    PaymentMethodResponseDTO updatePaymentMethod(Long id, PaymentMethodRequestDTO paymentMethodRequestDTO);
    List<PaymentMethodResponseDTO> findAllPaymentMethods();
    PaymentMethodResponseDTO findPaymentMethodById(Long id);
    void deletePaymentMethod(Long id);

}
