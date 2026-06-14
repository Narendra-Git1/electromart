package com.nari.electromart.service;

import com.nari.electromart.dto.RegisterRequest;

public interface UserService {

    String registerUser(RegisterRequest request);

}