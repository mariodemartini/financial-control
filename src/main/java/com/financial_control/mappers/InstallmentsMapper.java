package com.financial_control.mappers;

import com.financial_control.dtos.responses.InstallmentsResponseDTO;
import com.financial_control.entities.InstallmentsEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class InstallmentsMapper {

    public InstallmentsResponseDTO toDTO(InstallmentsEntity entity) {
        if (entity == null) return null;

        return InstallmentsResponseDTO.builder()
                .id(entity.getId())
                .installmentAmount(entity.getAmount())
                .number(entity.getNumber())
                .dueDate(entity.getDueDate())
                .paymentDate(entity.getPaymentDate())
                .status(entity.getStatus())
                .transactionDescription(entity.getTransaction().getDescription())
                .build();
    }

}
