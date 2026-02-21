package com.financial_control.repositories;

import com.financial_control.entities.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {

    List<CategoryEntity> findByUser(Long user);
    Optional<CategoryEntity> findByIdAndUser(Long id, Long user);

}
