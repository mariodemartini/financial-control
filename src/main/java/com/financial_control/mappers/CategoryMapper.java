package com.financial_control.mappers;

import com.financial_control.dtos.requests.CategoryRequestDTO;
import com.financial_control.dtos.responses.CategoryResponseDTO;
import com.financial_control.entities.CategoryEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CategoryMapper {

    public CategoryEntity toEntity(CategoryRequestDTO dto) {
        if (dto == null) return null;

        CategoryEntity entity = new CategoryEntity();
        if (dto.getName() != null) entity.setName(dto.getName());
        return entity;
    }

    public CategoryResponseDTO toDTO(CategoryEntity entity) {
        if (entity == null) return null;

        CategoryResponseDTO dto = new CategoryResponseDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        return dto;
    }

}
