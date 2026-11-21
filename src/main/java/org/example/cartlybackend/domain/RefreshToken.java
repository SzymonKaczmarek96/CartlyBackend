package org.example.cartlybackend.domain;

import lombok.*;

import java.time.Instant;
import java.util.UUID;

@EqualsAndHashCode
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RefreshToken {
    private UUID id;
    private String token;
    private Instant expiryDate;
    private boolean revoked;
    private User user;
}
