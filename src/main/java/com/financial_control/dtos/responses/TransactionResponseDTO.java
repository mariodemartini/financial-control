package com.financial_control.dtos.responses;

import com.financial_control.entities.enums.PaymentTypeEnum;
import com.financial_control.entities.enums.StatusEnum;
import com.financial_control.entities.enums.TransactionTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TransactionResponseDTO {

    private Long id;
    private String description;
    private BigDecimal amount;
    private LocalDate transactionDate;
    private LocalDate paymentDate;
    private PaymentTypeEnum paymentType;
    private Integer numberOfInstallments;
    private TransactionTypeEnum transactionType;
    private StatusEnum status;
    private String categoryName;
    private String cardName;
    private String lastFourNumbers;

}
