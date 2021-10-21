package com.example.demo.model.repository;

import com.example.demo.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<User, Integer> {
    User findFirstByUsernameOrEmail(String username, String email);
    User findByUsernameAndPasswordAndLevel(String username, String password, int level);
    User findByUsernameAndPassword(String username, String password);
}
