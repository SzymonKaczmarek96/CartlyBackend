package org.example.cartlybackend.domain;

import java.time.Instant;
import java.util.UUID;

public class RefreshToken {
    private UUID id;
    private String token;
    private Instant expiryDate;
    private boolean revoked; // for logout
    private User user;
}
