package com.nari.electromart.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nari.electromart.entity.User;

public interface UserRepository
        extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);
}