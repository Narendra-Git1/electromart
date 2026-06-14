package com.nari.electromart.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserTestController {

    @GetMapping("/api/user/test")
    public String userTest() {

        return "User Endpoint Working";
    }
}