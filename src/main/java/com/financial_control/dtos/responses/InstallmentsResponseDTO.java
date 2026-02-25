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
public class InstallmentsResponseDTO {

    private Long id;
    private Integer number;
    private BigDecimal installmentAmount;
    private LocalDate dueDate;
    private LocalDate paymentDate;
    private StatusEnum status;
    private String transactionDescription;

}
