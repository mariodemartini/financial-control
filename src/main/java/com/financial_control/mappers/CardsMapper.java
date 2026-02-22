package com.financial_control.mappers;

import com.financial_control.dtos.requests.CardsRequestDTO;
import com.financial_control.dtos.responses.CardsResponseDTO;
import com.financial_control.entities.CardsEntity;
import com.financial_control.entities.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CardsMapper {

    public CardsEntity toEntity(CardsRequestDTO dto, UserEntity user) {
        CardsEntity cardsEntity = CardsEntity.builder()
                .name(dto.getName())
                .lastNumbers(dto.getLastNumbers())
                .closingDay(dto.getClosingDay())
                .dueDay(dto.getDueDay())
                .user(user) // Associa o dono do cartão aqui
                .build();

        return cardsEntity;
    }

    public CardsResponseDTO toDTO(CardsEntity entity) {

        return CardsResponseDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .lastNumbers(entity.getLastNumbers())
                .closingDay(entity.getClosingDay())
                .dueDay(entity.getDueDay())
                .build();
    }

}
