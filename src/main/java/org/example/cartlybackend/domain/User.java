package org.example.cartlybackend.domain;

import lombok.*;

import java.time.Instant;
import java.util.UUID;

@Builder
@EqualsAndHashCode
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private UUID userId;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Instant createdDate;
    private Instant updatedDate;
    private UserRole role;
    private RegistrationStatus registrationStatus;
}
