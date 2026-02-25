package com.financial_control.entities;

import com.financial_control.entities.enums.StatusEnum;
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
@AllArgsConstructor
@NoArgsConstructor
public class InstallmentsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer number;
    private BigDecimal amount;
    private LocalDate dueDate;
    private LocalDate paymentDate;
    private StatusEnum status;

    @ManyToOne
    @JoinColumn(name = "transaction_id")
    private TransactionEntity transaction;

}
