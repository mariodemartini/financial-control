package com.financial_control.services;

import com.financial_control.dtos.requests.TransactionRequestDTO;
import com.financial_control.dtos.responses.TransactionResponseDTO;
import com.financial_control.entities.enums.StatusEnum;
import com.financial_control.entities.enums.TransactionTypeEnum;

public interface TransactionService {

    TransactionResponseDTO createTransaction(TransactionRequestDTO transactionRequestDTO);
    TransactionResponseDTO updateTransaction(Long id, TransactionRequestDTO transactionRequestDTO);
    TransactionResponseDTO findTransactionsByMonth(String month);
    TransactionResponseDTO findTransactionsByType(TransactionTypeEnum transactionType);
    TransactionResponseDTO findTransactionsByStatus(StatusEnum statusEnum);

}
