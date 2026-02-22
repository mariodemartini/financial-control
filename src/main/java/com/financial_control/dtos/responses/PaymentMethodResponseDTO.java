package com.financial_control.dtos.responses;

import com.financial_control.entities.enums.PaymentTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentMethodResponseDTO {

    private Long id;
    private String name;
    private PaymentTypeEnum paymentTypeEnum;

}
