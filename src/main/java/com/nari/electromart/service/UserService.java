package com.nari.electromart.service;

import com.nari.electromart.dto.LoginRequest;
import com.nari.electromart.dto.LoginResponse;
import com.nari.electromart.dto.RegisterRequest;
import com.nari.electromart.entity.User;

public interface UserService {

    String registerUser(RegisterRequest request);

    LoginResponse loginUser(LoginRequest request);
    
    User getUserById(Long id);

    User updateUser(Long id,
                    User user);
}