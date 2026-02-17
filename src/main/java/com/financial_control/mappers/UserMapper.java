package com.financial_control.mappers;

import com.financial_control.dtos.requests.UserRequestDTO;
import com.financial_control.dtos.responses.UserResponseDTO;
import com.financial_control.entities.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserMapper {

    private final PasswordEncoder passwordEncoder; // Spring injeta automaticamente via construtor

    // Converte UserRequestDTO -> UserEntity
    public UserEntity toEntity(UserRequestDTO dto) {
        if (dto == null) return null;

        UserEntity entity = new UserEntity();
        if (dto.getFirstName() != null) entity.setFirstName(dto.getFirstName());
        if (dto.getLastName() != null) entity.setLastName(dto.getLastName());
        if (dto.getEmail() != null) entity.setEmail(dto.getEmail());
        if (dto.getPassword() != null) {
            // hash da senha antes de salvar
            entity.setPassword(passwordEncoder.encode(dto.getPassword()));
        }
        return entity;
    }

    // Converte UserEntity -> UserResponseDTO
    public UserResponseDTO toDTO(UserEntity entity) {
        if (entity == null) return null;

        UserResponseDTO dto = new UserResponseDTO();
        dto.setId(entity.getId());
        dto.setFirstName(entity.getFirstName());
        dto.setLastName(entity.getLastName());
        dto.setEmail(entity.getEmail());
        // não retorna senha
        return dto;
    }
}
