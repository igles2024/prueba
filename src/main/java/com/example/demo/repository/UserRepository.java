package com.example.demo.repository;

/*
 * se realizo la implementacion 
 * de la siguentes interface para poder interactuar con la base de datos
 * 
 */

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.User;

import java.util.Optional;
public interface UserRepository  extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
