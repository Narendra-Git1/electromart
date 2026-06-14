package com.nari.electromart.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.nari.electromart.dto.LoginRequest;

import com.nari.electromart.dto.RegisterRequest;
import com.nari.electromart.entity.User;
import com.nari.electromart.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository,
                           BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public String registerUser(RegisterRequest request) {

        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            return "Email already exists";
        }

        User user = new User();

        user.setName(request.getName());
        user.setEmail(request.getEmail());

        user.setPassword(
                passwordEncoder.encode(request.getPassword()));

        user.setRole("USER");

        userRepository.save(user);

        return "User Registered Successfully";
    }
    
    @Override
    public String loginUser(LoginRequest request) {

        User user = userRepository
                .findByEmail(request.getEmail())
                .orElse(null);

        if (user == null) {
            return "Invalid Email";
        }

        boolean isMatch = passwordEncoder.matches(
                request.getPassword(),
                user.getPassword());

        if (!isMatch) {
            return "Invalid Password";
        }

        return "Login Successful";
    }
}