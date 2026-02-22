package com.financial_control.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CardsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String lastNumbers;
    private Integer closingDay;
    private Integer dueDay;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

}
