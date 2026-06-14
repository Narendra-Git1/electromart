package com.nari.electromart.service;

import com.nari.electromart.dto.LoginRequest;
import com.nari.electromart.dto.LoginResponse;
import com.nari.electromart.dto.RegisterRequest;

public interface UserService {

    String registerUser(RegisterRequest request);

    LoginResponse loginUser(LoginRequest request);
}