package com.financial_control.services;

import com.financial_control.dtos.requests.CategoryRequestDTO;
import com.financial_control.dtos.responses.CategoryResponseDTO;

import java.util.List;

public interface CategoryService {

    CategoryResponseDTO createCategory(CategoryRequestDTO categoryRequestDTO);
    List<CategoryResponseDTO> findAll();
    CategoryResponseDTO findById(Long id);
    CategoryResponseDTO updateCategory(Long id, CategoryRequestDTO categoryRequestDTO);
    void deleteById(Long Id);
}
