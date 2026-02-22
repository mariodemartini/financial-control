package com.financial_control.repositories;

import com.financial_control.entities.PaymentMethodEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PaymentMethodRepository extends JpaRepository<PaymentMethodEntity, Long> {

    List<PaymentMethodEntity> findByUserId(Long userId);
    Optional<PaymentMethodEntity> findByIdAndUserId(Long id, Long userId);

}
