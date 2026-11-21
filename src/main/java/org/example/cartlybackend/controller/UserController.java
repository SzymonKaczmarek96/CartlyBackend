package org.example.cartlybackend.controller;

import org.example.cartlybackend.jwt.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/")
public class UserController {
    @Autowired
    private JwtService jwtService;
}
