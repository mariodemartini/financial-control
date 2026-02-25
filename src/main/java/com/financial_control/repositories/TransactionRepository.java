package com.financial_control.repositories;

import com.financial_control.entities.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TransactionRepository extends JpaRepository<TransactionEntity, Long> {

    List<TransactionEntity> findByUserId(Long userId);

    Optional<TransactionEntity> findByIdAndUserId(Long id, Long userId);

}
