package org.example.cartlybackend.repository;

import org.example.cartlybackend.domain.User;
import org.example.cartlybackend.domain.UserRole;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Component
public class UserMockRepositoryImpl implements UserMockRepository {

    @Override
    public List<User> getUsers() {
        return List.of(
                User.builder().userId(UUID.fromString("11111111-1111-1111-1111-111111111111")).firstName("Jan").lastName("Kowalski").email("jan.kowalski@example.com").password("password1").createdDate(Instant.now()).updatedDate(Instant.now()).role(UserRole.USER).build(),
                User.builder().userId(UUID.fromString("22222222-2222-2222-2222-222222222222")).firstName("Anna").lastName("Nowak").email("anna.nowak@example.com").password("password2").createdDate(Instant.now()).updatedDate(Instant.now()).role(UserRole.USER).build(),
                User.builder().userId(UUID.fromString("33333333-3333-3333-3333-333333333333")).firstName("Marek").lastName("Wiśniewski").email("marek.wisniewski@example.com").password("password3").createdDate(Instant.now()).updatedDate(Instant.now()).role(UserRole.USER).build(),
                User.builder().userId(UUID.fromString("44444444-4444-4444-4444-444444444444")).firstName("Ewa").lastName("Zielińska").email("ewa.zielinska@example.com").password("password4").createdDate(Instant.now()).updatedDate(Instant.now()).role(UserRole.ADMIN).build(),
                User.builder().userId(UUID.fromString("55555555-5555-5555-5555-555555555555")).firstName("Tomasz").lastName("Lewandowski").email("tomasz.lewandowski@example.com").password("password5").createdDate(Instant.now()).updatedDate(Instant.now()).role(UserRole.USER).build()
        );
    }
}
