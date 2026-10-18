package org.example.cartlybackend.controller;

import org.example.cartlybackend.jwt.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.net.Authenticator;
import java.util.Map;

@RestController
@RequestMapping("api/")
public class AuthController {

    private final JwtService jwtService;

    public AuthController(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    @PostMapping("auth/login")
    public ResponseEntity<Map<String, String>> login(
            @RequestBody Map<String, String> loginRequest
    ) {

        String username = loginRequest.getOrDefault("username", "anonim");

        String token = jwtService.generateAccessToken(username,"USER");

        return ResponseEntity.ok(Map.of("token", token));
    }

    @GetMapping("secret")
    public ResponseEntity<Map<String, String>> getSecretData(Authentication authentication) {
        if (authentication == null) {
            return ResponseEntity.status(401).body(Map.of("error", "Brak uwierzytelnienia!"));
        }
        String username = authentication.getName();
        return ResponseEntity.ok(Map.of(
                "message", "Cześć " + username + "! Masz poprawny token, więc widzisz te tajne dane."
        )
        );

    }

}
