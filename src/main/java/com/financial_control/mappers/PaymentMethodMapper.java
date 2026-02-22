package com.financial_control.mappers;

import com.financial_control.dtos.requests.CategoryRequestDTO;
import com.financial_control.dtos.requests.PaymentMethodRequestDTO;
import com.financial_control.dtos.responses.CategoryResponseDTO;
import com.financial_control.dtos.responses.PaymentMethodResponseDTO;
import com.financial_control.entities.CategoryEntity;
import com.financial_control.entities.PaymentMethodEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PaymentMethodMapper {

    public PaymentMethodEntity toEntity(PaymentMethodRequestDTO dto) {
        if (dto == null) return null;

        PaymentMethodEntity entity = new PaymentMethodEntity();
        if (dto.getName() != null) entity.setName(dto.getName());
        if (dto.getPaymentTypeEnum() != null) entity.setPaymentTypeEnum(dto.getPaymentTypeEnum());
        return entity;
    }

    public PaymentMethodResponseDTO toDTO(PaymentMethodEntity entity) {
        if (entity == null) return null;

        PaymentMethodResponseDTO dto = new PaymentMethodResponseDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setPaymentTypeEnum(entity.getPaymentTypeEnum());
        return dto;
    }

}
