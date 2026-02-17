package com.financial_control.services.impl;

import com.financial_control.dtos.requests.UserRequestDTO;
import com.financial_control.dtos.responses.UserResponseDTO;
import com.financial_control.entities.UserEntity;
import com.financial_control.mappers.UserMapper;
import com.financial_control.repositories.UserRepository;
import com.financial_control.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserResponseDTO createUser(UserRequestDTO userDto) {
        UserEntity entity = userMapper.toEntity(userDto);
        UserEntity saved = userRepository.save(entity);
        return userMapper.toDTO(saved);
    }

    @Override
    public UserResponseDTO updateUser(Long Id, UserRequestDTO user) {
        UserEntity entity = userMapper.toEntity(user);
        entity.setId(Id);
        UserEntity updated = userRepository.save(entity);
        return userMapper.toDTO(updated);
    }

    @Override
    public UserResponseDTO findById(Long Id) {
        UserEntity entity = userRepository.findById(Id).orElseThrow();
        return userMapper.toDTO(entity);
    }

    @Override
    public List<UserResponseDTO> getAll() {
        Iterable<UserEntity> users = userRepository.findAll();
        return StreamSupport.stream(users.spliterator(), false)
                .map(userMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
        } else {
            throw new RuntimeException("Usuário com ID " + id + " não encontrado");
        }
    }

}
