package com.financial_control.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CardsRequestDTO {

    private String name;
    private String lastNumbers;
    private Integer closingDay;
    private Integer dueDay;


}
