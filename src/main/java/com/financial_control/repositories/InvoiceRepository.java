package com.financial_control.repositories;

import com.financial_control.entities.InvoiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InvoiceRepository extends JpaRepository<InvoiceEntity, Long> {

    List<InvoiceEntity> findByUserId(Long userId);
    Optional<InvoiceEntity> findByIdAndUserId(Long id, Long userId);

}
