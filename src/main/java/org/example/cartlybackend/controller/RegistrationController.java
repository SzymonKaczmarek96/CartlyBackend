package org.example.cartlybackend.controller;

import org.example.cartlybackend.domain.Registration;
import org.example.cartlybackend.dto.RegistrationRequest;
import org.example.cartlybackend.service.RegistrationService;
import org.example.cartlybackend.service.UserMockService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/registration/")
public class RegistrationController {

    private final RegistrationService registrationService;
    private final UserMockService userMockService;

    public RegistrationController(RegistrationService registrationService, UserMockService userMockService) {
        this.registrationService = registrationService;
        this.userMockService = userMockService;
    }

    // require refactor
    @PostMapping
    public ResponseEntity<?> register(@RequestBody RegistrationRequest registrationRequest) {
        Registration registration = registrationRequest.toDomain();
        registrationService.registerUser(registration);
        return ResponseEntity.ok("Registration successful");
    }

}
