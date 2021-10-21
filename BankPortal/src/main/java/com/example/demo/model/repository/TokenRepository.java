package com.example.demo.model.repository;

import com.example.demo.model.entities.Token;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TokenRepository extends JpaRepository<Token, Integer> {
    Token findByUserId(int id);
}
