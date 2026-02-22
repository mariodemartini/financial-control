package com.financial_control.controllers;

import com.financial_control.dtos.requests.CardsRequestDTO;
import com.financial_control.dtos.responses.CardsResponseDTO;
import com.financial_control.services.CardsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cards")
public class CardsController {

    @Autowired
    private CardsService cardsService;

    @PostMapping
    public CardsResponseDTO createCard(@RequestBody CardsRequestDTO cardsRequestDTO) {
        return cardsService.createCard(cardsRequestDTO);
    }

    @GetMapping
    public List<CardsResponseDTO> getAllCards() {
        return cardsService.findAllCards();
    }

    @GetMapping("/card/{id}")
    public CardsResponseDTO getCardById(@PathVariable Long id) {
        return cardsService.findCardById(id);
    }

    @PutMapping("/card/{id}")
    public CardsResponseDTO updateCard(@PathVariable Long id, @RequestBody CardsRequestDTO cardsRequestDTO) {
        return cardsService.updateCard(id, cardsRequestDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteCardById(@PathVariable Long id) {
        cardsService.deleteCard(id);
    }

}
