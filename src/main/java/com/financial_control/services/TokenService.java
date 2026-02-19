package com.financial_control.services;

import com.financial_control.entities.UserEntity;

public interface TokenService {
    String generateToken(UserEntity user);
    String validateToken(String token);

}
