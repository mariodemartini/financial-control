package com.financial_control.services;

import com.financial_control.dtos.requests.UserRequestDTO;
import com.financial_control.dtos.responses.UserResponseDTO;
import com.financial_control.entities.UserEntity;

import java.util.List;

public interface UserService {

    UserResponseDTO createUser(UserRequestDTO user);
    UserResponseDTO updateUser(Long Id, UserRequestDTO user);
    UserResponseDTO findById(Long Id);
    UserResponseDTO findByEmail(String email);
    List<UserResponseDTO> getAll();
    void deleteById(Long Id);

}
