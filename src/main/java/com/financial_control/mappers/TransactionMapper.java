package com.financial_control.mappers;

import com.financial_control.dtos.requests.TransactionRequestDTO;
import com.financial_control.dtos.responses.CategoryResponseDTO;
import com.financial_control.dtos.responses.TransactionResponseDTO;
import com.financial_control.entities.CardsEntity;
import com.financial_control.entities.CategoryEntity;
import com.financial_control.entities.TransactionEntity;
import com.financial_control.entities.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TransactionMapper {

    public TransactionEntity toEntity(TransactionRequestDTO dto, CardsEntity card,CategoryEntity category, UserEntity user) {
        if (dto == null) return null;

        return TransactionEntity.builder()
                .description(dto.getDescription())
                .amount(dto.getAmount())
                .transactionDate(dto.getTransactionDate())
                .paymentDate(dto.getPaymentDate())
                .paymentType(dto.getPaymentType())
                .numberOfInstallments(dto.getNumberOfInstallments())
                .transactionType(dto.getTransactionType())
                .status(dto.getStatus())
                .card(card)
                .category(category)
                .user(user)
                .build();

    }

    public TransactionResponseDTO toDTO(TransactionEntity entity) {
        if (entity == null) return null;

        return TransactionResponseDTO.builder()
                .id(entity.getId())
                .description(entity.getDescription())
                .amount(entity.getAmount())
                .transactionDate(entity.getTransactionDate())
                .paymentDate(entity.getPaymentDate())
                .paymentType(entity.getPaymentType())
                .numberOfInstallments(entity.getNumberOfInstallments())
                .transactionType(entity.getTransactionType())
                .status(entity.getStatus())
                .categoryName(entity.getCategory() != null ? entity.getCategory().getName() : null)
                .cardName(entity.getCard() != null ? entity.getCard().getName() : "N/A")
                .lastFourNumbers(entity.getCard() != null ? entity.getCard().getLastNumbers() : null)
                .build();
    }

}
