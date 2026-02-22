package com.financial_control.services.impl;

import com.financial_control.dtos.requests.CardsRequestDTO;
import com.financial_control.dtos.responses.CardsResponseDTO;
import com.financial_control.entities.CardsEntity;
import com.financial_control.entities.UserEntity;
import com.financial_control.mappers.CardsMapper;
import com.financial_control.repositories.CardsRepository;
import com.financial_control.services.CardsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardsServiceImpl implements CardsService {

    @Autowired
    private CardsRepository cardsRepository;

    @Autowired
    private CardsMapper cardsMapper;

    @Autowired
    private AuthorizationService authorizationService;

    @Override
    public CardsResponseDTO createCard(CardsRequestDTO cardsRequestDTO) {
        UserEntity user = authorizationService.getAuthenticatedUser();

        CardsEntity cardsEntity = cardsMapper.toEntity(cardsRequestDTO, user);

        return cardsMapper.toDTO(cardsRepository.save(cardsEntity));

    }

    @Override
    public CardsResponseDTO updateCard(Long id, CardsRequestDTO cardsRequestDTO) {
        UserEntity user = authorizationService.getAuthenticatedUser();

        CardsEntity card = cardsRepository.findByIdAndUserId(id, user.getId())
                .orElseThrow(() -> new RuntimeException("Cartão não encontrado"));

        card.setName(cardsRequestDTO.getName());
        card.setLastNumbers(cardsRequestDTO.getLastNumbers());
        card.setClosingDay(cardsRequestDTO.getClosingDay());
        card.setDueDay(cardsRequestDTO.getDueDay());

        return cardsMapper.toDTO(cardsRepository.save(card));

    }

    @Override
    public List<CardsResponseDTO> findAllCards() {
        UserEntity user = authorizationService.getAuthenticatedUser();

        return cardsRepository.findByUserId(user.getId())
                    .stream()
                    .map(cardsMapper::toDTO)
                    .toList();

    }

    @Override
    public CardsResponseDTO findCardById(Long id) {
        UserEntity user = authorizationService.getAuthenticatedUser();

        CardsEntity cardsEntity = cardsRepository.findByIdAndUserId(id, user.getId())
                .orElseThrow(() -> new RuntimeException("Metodo de pagamento não encontrado ou acesso negado"));

        return cardsMapper.toDTO(cardsEntity);

    }


    @Override
    public void deleteCard(Long id) {
        UserEntity user = authorizationService.getAuthenticatedUser();

        CardsEntity cardsEntity = cardsRepository.findByIdAndUserId(id, user.getId())
                .orElseThrow(() -> new RuntimeException("Não encontrado"));

        cardsRepository.delete(cardsEntity);

    }

}
