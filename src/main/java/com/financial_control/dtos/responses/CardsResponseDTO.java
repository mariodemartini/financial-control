package com.financial_control.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CardsResponseDTO {

    private Long id;
    private String name;
    private String lastNumbers;
    private Integer closingDay;
    private Integer dueDay;

}
