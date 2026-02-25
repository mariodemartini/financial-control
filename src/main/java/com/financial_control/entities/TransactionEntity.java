package com.financial_control.entities;

import com.financial_control.entities.enums.PaymentTypeEnum;
import com.financial_control.entities.enums.StatusEnum;
import com.financial_control.entities.enums.TransactionTypeEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private BigDecimal amount;
    private LocalDate transactionDate;
    private PaymentTypeEnum  paymentType;
    private Integer numberOfInstallments;
    private TransactionTypeEnum transactionType;
    private StatusEnum  status;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private CategoryEntity category;

    @ManyToOne
    @JoinColumn(name = "card_id")
    private CardsEntity card;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

}
