package com.nari.electromart.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.nari.electromart.dto.UserDashboardDTO;
import com.nari.electromart.service.UserDashboardService;

@RestController
@RequestMapping("/api/user")
public class UserDashboardController {

    private final UserDashboardService
            userDashboardService;

    public UserDashboardController(
            UserDashboardService userDashboardService) {

        this.userDashboardService =
                userDashboardService;
    }

    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    @GetMapping("/dashboard/{userId}")
    public UserDashboardDTO getDashboard(
            @PathVariable Long userId) {

        return userDashboardService
                .getDashboard(userId);
    }
}