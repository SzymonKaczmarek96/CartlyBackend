package org.example.cartlybackend.service;

import org.example.cartlybackend.domain.Registration;
import org.example.cartlybackend.domain.RegistrationStatus;
import org.example.cartlybackend.domain.User;
import org.example.cartlybackend.domain.UserRole;
import org.example.cartlybackend.repository.UserMockRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Service
public class UserMockService {

    private final UserMockRepository userMockRepository;
    private final PasswordEncoder passwordEncoder;

    public UserMockService(UserMockRepository userMockRepository,
                           PasswordEncoder passwordEncoder
    ) {
        this.userMockRepository = userMockRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void createUser(Registration registration){

        User user = User.builder()
                .userId(UUID.randomUUID())
                .firstName(registration.getFirstName())
                .lastName(registration.getLastName())
                .password(passwordEncoder.encode(registration.getPassword()))
                .email(registration.getEmail())
                .role(UserRole.USER)
                .createdDate(Instant.now())
                .updatedDate(Instant.now())
                .registrationStatus(RegistrationStatus.INACTIVE)
                .build();
    }

    private List<User> getUsers() {
        return userMockRepository.getUsers();
    }

    public User authorizeUser(String email, String password) {
        User user = getUsers().stream().filter( u ->
                u.getEmail().equals(email)).findFirst().orElse(null);
        if(user == null){
            return null;
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        if(!passwordEncoder.matches(password, user.getPassword())){
            return null;
        }
        return user;
    }
}
