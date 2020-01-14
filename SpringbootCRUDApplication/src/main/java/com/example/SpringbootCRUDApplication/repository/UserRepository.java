package com.example.SpringbootCRUDApplication.repository;

import com.example.SpringbootCRUDApplication.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {

Optional<User> findByEmail(String email);
}
