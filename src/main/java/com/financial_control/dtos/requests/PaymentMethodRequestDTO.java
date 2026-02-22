package com.financial_control.dtos.requests;

import com.financial_control.entities.UserEntity;
import com.financial_control.entities.enums.PaymentTypeEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentMethodRequestDTO {

    private String name;
    private PaymentTypeEnum paymentTypeEnum;

}
