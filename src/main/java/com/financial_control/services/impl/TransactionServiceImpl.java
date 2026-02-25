package com.financial_control.services.impl;

import com.financial_control.entities.TransactionEntity;
import com.financial_control.entities.UserEntity;
import com.financial_control.entities.enums.StatusEnum;
import com.financial_control.entities.enums.TransactionTypeEnum;
import com.financial_control.repositories.TransactionRepository;
import com.financial_control.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private AuthorizationService authorizationService;

    @Override
    public TransactionEntity createTransaction(TransactionEntity transactionEntity) {
        UserEntity user = authorizationService.getAuthenticatedUser();

        if (transactionEntity.getTransactionType() == TransactionTypeEnum.REVENUE){

        }

        return null;
    }

    @Override
    public TransactionEntity updateTransaction(Long id, TransactionEntity transactionEntity) {
        return null;
    }

    @Override
    public TransactionEntity findTransactionsByMonth(String month) {
        return null;
    }

    @Override
    public TransactionEntity findTransactionsByType(TransactionTypeEnum transactionType) {
        return null;
    }

    @Override
    public TransactionEntity findTransactionsByStatus(StatusEnum statusEnum) {
        return null;
    }
}
