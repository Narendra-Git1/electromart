package com.nari.electromart.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.nari.electromart.dto.LoginRequest;
import com.nari.electromart.dto.LoginResponse;
import com.nari.electromart.dto.RegisterRequest;
import com.nari.electromart.entity.User;
import com.nari.electromart.repository.UserRepository;
import com.nari.electromart.security.JwtUtil;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public UserServiceImpl(
            UserRepository userRepository,
            BCryptPasswordEncoder passwordEncoder,
            JwtUtil jwtUtil) {

        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
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
                passwordEncoder.encode(
                        request.getPassword()));
        user.setRole("USER");

        userRepository.save(user);

        return "User Registered Successfully";
    }

    @Override
    public LoginResponse loginUser(LoginRequest request) {

        User user = userRepository
                .findByEmail(request.getEmail())
                .orElse(null);

        if (user == null) {
            throw new RuntimeException("Invalid Email");
        }

        boolean isMatch = passwordEncoder.matches(
                request.getPassword(),
                user.getPassword());

        if (!isMatch) {
            throw new RuntimeException("Invalid Password");
        }

        String token =
                jwtUtil.generateToken(
                        user.getEmail(),
                        user.getRole());

        return new LoginResponse(token);
    }
    
    @Override
    public User getUserById(Long id) {

        return userRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException(
                                "User Not Found"));
    }

    @Override
    public User updateUser(
            Long id,
            User user) {

        User existingUser =
                getUserById(id);

        existingUser.setName(
                user.getName());

        existingUser.setEmail(
                user.getEmail());

        return userRepository.save(
                existingUser);
    }
}