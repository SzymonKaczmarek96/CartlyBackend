package org.example.cartlybackend.controller;

import org.example.cartlybackend.domain.User;
import org.example.cartlybackend.repository.UserMockRepositoryImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class UserController {

    private final UserMockRepositoryImpl userRepository;

    public UserController(UserMockRepositoryImpl userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("users")
    public List<User> getUsers(){
        return userRepository.getUsers();
    }
}
