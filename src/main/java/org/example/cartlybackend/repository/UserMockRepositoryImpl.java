package org.example.cartlybackend.repository;

import org.example.cartlybackend.domain.User;
import org.example.cartlybackend.domain.UserRole;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class UserMockRepositoryImpl implements UserMockRepository {

    @Override
    public List<User> getUsers() {
        return List.of(
                new User(UUID.fromString("11111111-1111-1111-1111-111111111111"), "Jan", "Kowalski", "jan.kowalski@example.com", "password1", UserRole.USER),
                new User(UUID.fromString("22222222-2222-2222-2222-222222222222"), "Anna", "Nowak", "anna.nowak@example.com", "password2", UserRole.USER),
                new User(UUID.fromString("33333333-3333-3333-3333-333333333333"), "Marek", "Wiśniewski", "marek.wisniewski@example.com", "password3", UserRole.USER),
                new User(UUID.fromString("44444444-4444-4444-4444-444444444444"), "Ewa", "Zielińska", "ewa.zielinska@example.com", "password4", UserRole.ADMIN),
                new User(UUID.fromString("55555555-5555-5555-5555-555555555555"), "Tomasz", "Lewandowski", "tomasz.lewandowski@example.com", "password5", UserRole.USER)
        );
    }
}
