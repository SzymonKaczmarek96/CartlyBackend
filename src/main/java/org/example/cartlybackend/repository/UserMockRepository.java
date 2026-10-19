package org.example.cartlybackend.repository;

import org.example.cartlybackend.domain.User;

import java.util.List;

public interface UserMockRepository {
    List<User> getUsers();
}
