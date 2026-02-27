package com.financial_control.services.impl;

import com.financial_control.dtos.requests.TransactionRequestDTO;
import com.financial_control.dtos.responses.TransactionResponseDTO;
import com.financial_control.entities.CardsEntity;
import com.financial_control.entities.CategoryEntity;
import com.financial_control.entities.TransactionEntity;
import com.financial_control.entities.UserEntity;
import com.financial_control.entities.enums.PaymentTypeEnum;
import com.financial_control.entities.enums.StatusEnum;
import com.financial_control.entities.enums.TransactionTypeEnum;
import com.financial_control.mappers.TransactionMapper;
import com.financial_control.repositories.CardsRepository;
import com.financial_control.repositories.CategoryRepository;
import com.financial_control.repositories.TransactionRepository;
import com.financial_control.services.CardsService;
import com.financial_control.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private AuthorizationService authorizationService;

    @Autowired
    private TransactionMapper transactionMapper;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CardsRepository cardsRepository;

    @Autowired
    private CardsService cardsService;


    @Override
    public TransactionResponseDTO createTransaction(TransactionRequestDTO transactionRequestDTO) {

        UserEntity user = authorizationService.getAuthenticatedUser();

        CategoryEntity category = categoryRepository.findById(transactionRequestDTO.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));

        TransactionEntity transaction = new TransactionEntity();
        transaction.setDescription(transactionRequestDTO.getDescription());
        transaction.setAmount(transactionRequestDTO.getAmount());
        transaction.setTransactionDate(transactionRequestDTO.getTransactionDate());
        transaction.setStatus(transactionRequestDTO.getStatus());
        transaction.setCategory(category);
        transaction.setUser(user);
        transaction.setTransactionType(transactionRequestDTO.getTransactionType());

        if (transactionRequestDTO.getTransactionType() == TransactionTypeEnum.EXPENSE){
            CardsEntity card = validateCreditCard(transactionRequestDTO, user);

            transaction.setPaymentType(transactionRequestDTO.getPaymentType());
            transaction.setCard(card);
            transaction.setPaymentDate(validatePaymentType(transactionRequestDTO, card));

            transaction.setNumberOfInstallments(1);

            return transactionMapper.toDTO(transactionRepository.save(transaction));
        
        }
        else if (transactionRequestDTO.getTransactionType() == TransactionTypeEnum.REVENUE) {
            transaction.setPaymentDate(transactionRequestDTO.getPaymentDate());
            transaction.setPaymentType(transactionRequestDTO.getPaymentType());
            transaction.setNumberOfInstallments(1);

            return transactionMapper.toDTO(transactionRepository.save(transaction));
        }
        return null;

    }

    public CardsEntity validateCreditCard(TransactionRequestDTO transactionRequestDTO, UserEntity user) {
        if (transactionRequestDTO.getPaymentType() == PaymentTypeEnum.CREDIT_CARD){
            return cardsRepository.findByIdAndUserId(transactionRequestDTO.getCardId(), user.getId())
                    .orElseThrow(() -> new RuntimeException("Cartão não encontrado"));
        }
        return null;
    }

    public LocalDate validatePaymentType(TransactionRequestDTO transactionRequestDTO, CardsEntity card) {

        if (transactionRequestDTO.getPaymentType() == null){
            throw new RuntimeException("O tipo de pagamento é obrigatório.");
        }
        if (transactionRequestDTO.getPaymentType() == PaymentTypeEnum.CREDIT_CARD){
            return cardsService.calculatePaymentDate(card, transactionRequestDTO.getTransactionDate());

        } else {
            return transactionRequestDTO.getPaymentDate();
        }
    }



    @Override
    public TransactionResponseDTO updateTransaction(Long id, TransactionRequestDTO transactionRequestDTO) {
        return null;
    }

    @Override
    public TransactionResponseDTO findTransactionsByMonth(String month) {
        return null;
    }

    @Override
    public TransactionResponseDTO findTransactionsByType(TransactionTypeEnum transactionType) {
        return null;
    }

    @Override
    public TransactionResponseDTO findTransactionsByStatus(StatusEnum statusEnum) {
        return null;
    }

}
