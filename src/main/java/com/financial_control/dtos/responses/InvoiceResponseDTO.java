package com.financial_control.dtos.responses;

import com.financial_control.entities.enums.StatusEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InvoiceResponseDTO {

    private Long id;
    private Long cardId;
    private LocalDate referenceMonth;
    private BigDecimal totalAmount;
    private StatusEnum status;

}
