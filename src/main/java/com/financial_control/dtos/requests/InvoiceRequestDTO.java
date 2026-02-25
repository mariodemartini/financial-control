package com.financial_control.dtos.requests;

import com.financial_control.entities.enums.StatusEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceRequestDTO {

    private Long cardId;
    private LocalDate referenceMonth;
    private StatusEnum status;

}
