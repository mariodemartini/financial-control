package com.financial_control.services;

import com.financial_control.dtos.requests.CardsRequestDTO;
import com.financial_control.dtos.responses.CardsResponseDTO;

import java.util.List;

public interface CardsService {

    CardsResponseDTO createCard(CardsRequestDTO cardsRequestDTO);
    CardsResponseDTO updateCard(Long id, CardsRequestDTO cardsRequestDTO);
    List<CardsResponseDTO> findAllCards();
    CardsResponseDTO findCardById(Long id);
    void deleteCard(Long id);

}
