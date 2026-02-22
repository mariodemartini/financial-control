package com.financial_control.services.impl;

import com.financial_control.dtos.requests.PaymentMethodRequestDTO;
import com.financial_control.dtos.responses.PaymentMethodResponseDTO;
import com.financial_control.entities.PaymentMethodEntity;
import com.financial_control.entities.UserEntity;
import com.financial_control.mappers.PaymentMethodMapper;
import com.financial_control.repositories.PaymentMethodRepository;
import com.financial_control.services.PaymentMethodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentMethodServiceImpl implements PaymentMethodService {

    @Autowired
    private PaymentMethodRepository paymentMethodRepository;

    @Autowired
    private PaymentMethodMapper paymentMethodMapper;

    @Autowired
    private AuthorizationService authorizationService;

    @Override
    public PaymentMethodResponseDTO createPaymentMethod(PaymentMethodRequestDTO paymentMethodRequestDTO) {
        UserEntity user = authorizationService.getAuthenticatedUser();

        PaymentMethodEntity paymentMethodEntity = paymentMethodMapper.toEntity(paymentMethodRequestDTO);
        paymentMethodEntity.setUser(user);

        return paymentMethodMapper.toDTO(paymentMethodRepository.save(paymentMethodEntity));

    }

    @Override
    public PaymentMethodResponseDTO updatePaymentMethod(Long id, PaymentMethodRequestDTO paymentMethodRequestDTO) {
        UserEntity user = authorizationService.getAuthenticatedUser();

        PaymentMethodEntity paymentMethodEntity = paymentMethodRepository.findByIdAndUserId(id, user.getId())
                .orElseThrow(() -> new RuntimeException("Metodo de pagamento não encontrado ou acesso negado"));

        paymentMethodEntity.setName(paymentMethodRequestDTO.getName());
        paymentMethodEntity.setPaymentTypeEnum(paymentMethodRequestDTO.getPaymentTypeEnum());

        return paymentMethodMapper.toDTO(paymentMethodRepository.save(paymentMethodEntity));

    }

    @Override
    public List<PaymentMethodResponseDTO> findAllPaymentMethods() {
        UserEntity user = authorizationService.getAuthenticatedUser();

        return paymentMethodRepository.findByUserId(user.getId())
                    .stream()
                    .map(paymentMethodMapper::toDTO)
                    .toList();

    }

    @Override
    public PaymentMethodResponseDTO findPaymentMethodById(Long id) {
        UserEntity user = authorizationService.getAuthenticatedUser();

        PaymentMethodEntity paymentMethodEntity = paymentMethodRepository.findByIdAndUserId(id, user.getId())
                .orElseThrow(() -> new RuntimeException("Metodo de pagamento não encontrado ou acesso negado"));

        return paymentMethodMapper.toDTO(paymentMethodEntity);

    }

    @Override
    public void deletePaymentMethod(Long id) {
        UserEntity user = authorizationService.getAuthenticatedUser();

        PaymentMethodEntity paymentMethodEntity = paymentMethodRepository.findByIdAndUserId(id, user.getId())
                .orElseThrow(() -> new RuntimeException("Não encontrado"));

        paymentMethodRepository.delete(paymentMethodEntity);

    }
}
