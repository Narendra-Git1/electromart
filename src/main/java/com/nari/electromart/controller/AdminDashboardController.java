package com.nari.electromart.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nari.electromart.dto.AdminDashboardDTO;
import com.nari.electromart.repository.CategoryRepository;
import com.nari.electromart.repository.ProductRepository;
import com.nari.electromart.repository.UserRepository;

@RestController
public class AdminDashboardController {

    private final UserRepository userRepository;
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public AdminDashboardController(
            UserRepository userRepository,
            ProductRepository productRepository,
            CategoryRepository categoryRepository) {

        this.userRepository = userRepository;
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/api/admin/dashboard")
    public AdminDashboardDTO getDashboard() {

        return new AdminDashboardDTO(
                userRepository.count(),
                productRepository.count(),
                categoryRepository.count());
    }
}