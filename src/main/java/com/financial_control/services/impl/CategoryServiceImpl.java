package com.financial_control.services.impl;

import com.financial_control.dtos.requests.CategoryRequestDTO;
import com.financial_control.dtos.responses.CategoryResponseDTO;
import com.financial_control.entities.CategoryEntity;
import com.financial_control.entities.UserEntity;
import com.financial_control.mappers.CategoryMapper;
import com.financial_control.repositories.CategoryRepository;
import com.financial_control.repositories.UserRepository;
import com.financial_control.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CategoryMapper categoryMapper;

    @Autowired
    private AuthorizationService authorizationService;

    @Override
    public CategoryResponseDTO createCategory(CategoryRequestDTO categoryRequestDTO) {
        UserEntity user = authorizationService.getAuthenticatedUser();

        CategoryEntity categoryEntity = categoryMapper.toEntity(categoryRequestDTO);
        categoryEntity.setUser(user);

        return categoryMapper.toDTO(categoryRepository.save(categoryEntity));

    }

    @Override
    public CategoryResponseDTO findById(Long id) {
        UserEntity user = authorizationService.getAuthenticatedUser();

        CategoryEntity category = categoryRepository.findByIdAndUser(id, user)
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada ou acesso negado"));

        return categoryMapper.toDTO(category);
    }

    @Override
    public List<CategoryResponseDTO> findAll() {
        UserEntity user = authorizationService.getAuthenticatedUser();

        return categoryRepository.findByUser(user)
                .stream()
                .map(categoryMapper::toDTO)
                .toList();
    }

    @Override
    public CategoryResponseDTO updateCategory(Long id, CategoryRequestDTO categoryRequestDTO) {
        UserEntity user = authorizationService.getAuthenticatedUser();

        CategoryEntity categoryEntity = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));

        if (!categoryEntity.getUser().getId().equals(user.getId())) {
            throw new RuntimeException("Você não tem permissão para alterar esta categoria!");
        }

        categoryEntity.setName(categoryRequestDTO.getName());

        return categoryMapper.toDTO(categoryRepository.save(categoryEntity));
    }

    @Override
    public void deleteById(Long id) {
        UserEntity user = authorizationService.getAuthenticatedUser();

        CategoryEntity category = categoryRepository.findByIdAndUser(id, user)
                .orElseThrow(() -> new RuntimeException("Não encontrado"));

        categoryRepository.delete(category);

    }

}
