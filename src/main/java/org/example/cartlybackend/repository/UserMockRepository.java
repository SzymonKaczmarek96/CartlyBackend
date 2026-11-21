package org.example.cartlybackend.repository;

import org.example.cartlybackend.domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMockRepository {
    List<User> getUsers();
}
