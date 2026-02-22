package com.financial_control.repositories;

import com.financial_control.entities.CardsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CardsRepository extends JpaRepository<CardsEntity, Long> {

    List<CardsEntity> findByUserId(Long userId);

    Optional<CardsEntity> findByIdAndUserId(Long id, Long userId);

}
