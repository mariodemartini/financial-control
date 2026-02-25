package com.financial_control.mappers;

import com.financial_control.dtos.requests.InvoiceRequestDTO;
import com.financial_control.dtos.responses.InvoiceResponseDTO;
import com.financial_control.entities.CardsEntity;
import com.financial_control.entities.InvoiceEntity;
import com.financial_control.entities.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class InvoiceMapper {

    public InvoiceEntity toEntity(InvoiceRequestDTO dto, CardsEntity card, UserEntity user) {

        return InvoiceEntity.builder()
                .card(card)
                .referenceMonth(dto.getReferenceMonth())
                .status(dto.getStatus())
                .user(user)
                .build();
    }

    public InvoiceResponseDTO toDTO(InvoiceEntity entity) {

        return InvoiceResponseDTO.builder()
                .id(entity.getId())
                .cardId(entity.getCard().getId())
                .referenceMonth(entity.getReferenceMonth())
                .totalAmount(entity.getTotalAmount())
                .status(entity.getStatus())
                .build();
    }

}
