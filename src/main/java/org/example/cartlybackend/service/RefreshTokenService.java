package org.example.cartlybackend.service;

import org.example.cartlybackend.domain.RefreshToken;
import org.example.cartlybackend.domain.User;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.UUID;

@Service
public class RefreshTokenService {
    public RefreshToken generateRefreshToken(User user) {
        return new RefreshToken(
                UUID.randomUUID(),
                UUID.randomUUID().toString(),
                java.time.Instant.now().plusSeconds(60 * 60 * 24 * 30),
                false,
                user
        );
    }

    public RefreshToken findRefreshToken(String token) {
        // Implementation for finding refresh token
        return null;
    }

    public boolean validateRefreshToken(RefreshToken refreshToken) {
        return !refreshToken.isRevoked() && refreshToken.getExpiryDate().isAfter(Instant.now());
    }

}
