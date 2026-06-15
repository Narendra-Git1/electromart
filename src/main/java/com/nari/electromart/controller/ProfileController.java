package com.nari.electromart.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.nari.electromart.entity.User;
import com.nari.electromart.service.UserService;

@RestController
@RequestMapping("/api/profile")
public class ProfileController {

    private final UserService userService;

    public ProfileController(
            UserService userService) {

        this.userService = userService;
    }

    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    @GetMapping("/{id}")
    public User getProfile(
            @PathVariable Long id) {

        return userService.getUserById(id);
    }

    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    @PutMapping("/{id}")
    public User updateProfile(
            @PathVariable Long id,
            @RequestBody User user) {

        return userService.updateUser(
                id,
                user);
    }
}