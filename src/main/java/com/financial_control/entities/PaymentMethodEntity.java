package com.financial_control.entities;

import com.financial_control.entities.enums.PaymentTypeEnum;
import jakarta.persistence.*;
import jdk.jfr.Enabled;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentMethodEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private PaymentTypeEnum paymentTypeEnum;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

}
