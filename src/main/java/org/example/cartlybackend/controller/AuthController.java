package org.example.cartlybackend.controller;

import org.example.cartlybackend.domain.RefreshToken;
import org.example.cartlybackend.domain.User;
import org.example.cartlybackend.dto.AuthorizeResponse;
import org.example.cartlybackend.dto.LoginRequest;
import org.example.cartlybackend.dto.RefreshRequest;
import org.example.cartlybackend.jwt.JwtService;
import org.example.cartlybackend.service.RefreshTokenService;
import org.example.cartlybackend.service.UserMockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("api/auth/")
public class AuthController {

    private final UserMockService userMockService;
    private final JwtService jwtService;
    private final RefreshTokenService refreshTokenService;

    @Autowired
    public AuthController(UserMockService userMockService, JwtService jwtService, RefreshTokenService refreshTokenService) {
        this.userMockService = userMockService;
        this.jwtService = jwtService;
        this.refreshTokenService = refreshTokenService;
    }

    @GetMapping("authorize")
    public ResponseEntity<AuthorizeResponse> getSecretData(Authentication authentication) {
        if (authentication == null) {
            return ResponseEntity.status(401).body(new AuthorizeResponse("Unauthorized", false));
        }
        return ResponseEntity.ok(new AuthorizeResponse("Authorized successfully", true));
    }

    @PostMapping("login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        User user = userMockService.authorizeUser(request.username(), request.password());
        if (user == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body("Invalid username or password");
        }
        String token = generateAccessToken(user);
        RefreshToken refreshToken = generateRefreshToken(user);
        return ResponseEntity.ok(Map.of("token", token, "refresh_token", refreshToken.getToken()));
    }

    @PostMapping("refresh")
    public ResponseEntity<?> refresh(@RequestBody RefreshRequest request) {
        String refreshToken = request.refreshToken();
        RefreshToken refreshTokenObj = refreshTokenService.findRefreshToken(refreshToken);
        if (refreshTokenObj == null || !refreshTokenService.validateRefreshToken(refreshTokenObj)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid or expired refresh token");
        }
        String token = generateAccessToken(refreshTokenObj.getUser());
        refreshTokenObj.setRevoked(true);
        RefreshToken generateRefreshToken = generateRefreshToken(refreshTokenObj.getUser());
        //future save into db

        return ResponseEntity.ok(Map.of("token", token, "refresh_token", generateRefreshToken.getToken()));
    }

    private String generateAccessToken(User user) {
        return jwtService.generateAccessToken(user.getEmail(), user.getRole().name());
    }

    private RefreshToken generateRefreshToken(User user) {
        return refreshTokenService.generateRefreshToken(user);
    }
}