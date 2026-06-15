package com.nari.electromart.service;

import org.springframework.stereotype.Service;

import com.nari.electromart.dto.UserDashboardDTO;
import com.nari.electromart.entity.User;
import com.nari.electromart.repository.CartItemRepository;
import com.nari.electromart.repository.UserRepository;

@Service
public class UserDashboardServiceImpl
        implements UserDashboardService {

    private final UserRepository userRepository;
    private final CartItemRepository cartItemRepository;

    public UserDashboardServiceImpl(
            UserRepository userRepository,
            CartItemRepository cartItemRepository) {

        this.userRepository = userRepository;
        this.cartItemRepository = cartItemRepository;
    }

    @Override
    public UserDashboardDTO getDashboard(
            Long userId) {

        User user = userRepository.findById(userId)
                .orElseThrow(() ->
                        new RuntimeException(
                                "User Not Found"));

        long cartItems =
                cartItemRepository.countByUserId(
                        userId);

        return new UserDashboardDTO(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getRole(),
                cartItems);
    }
}