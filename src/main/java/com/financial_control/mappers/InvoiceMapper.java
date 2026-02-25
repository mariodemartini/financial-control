package com.financial_control.mappers;

import com.financial_control.dtos.responses.InvoiceResponseDTO;
import com.financial_control.entities.InvoiceEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class InvoiceMapper {

    public InvoiceResponseDTO toDTO(InvoiceEntity entity) {

        return InvoiceResponseDTO.builder()
                .id(entity.getId())
                .cardName(entity.getCard().getName())
                .referenceMonth(entity.getReferenceMonth())
                .totalAmount(entity.getTotalAmount())
                .status(entity.getStatus())
                .build();
    }

}
