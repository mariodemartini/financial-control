package com.financial_control.repositories;

import com.financial_control.entities.InstallmentsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InstallmentsRepository extends JpaRepository<InstallmentsEntity, Long> {

    List<InstallmentsEntity> findByUserId(Long userId);

    Optional<InstallmentsEntity> findByIdAndUserId(Long id, Long userId);

}
