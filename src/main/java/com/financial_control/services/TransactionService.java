package com.financial_control.services;

import com.financial_control.entities.TransactionEntity;
import com.financial_control.entities.enums.StatusEnum;
import com.financial_control.entities.enums.TransactionTypeEnum;

public interface TransactionService {

    TransactionEntity createTransaction(TransactionEntity transactionEntity);
    TransactionEntity updateTransaction(Long id, TransactionEntity transactionEntity);
    TransactionEntity findTransactionsByMonth(String month);
    TransactionEntity findTransactionsByType(TransactionTypeEnum transactionType);
    TransactionEntity findTransactionsByStatus(StatusEnum statusEnum);

}
