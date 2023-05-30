package com.example.mechanic_shop.admin.repository;

import com.example.mechanic_shop.admin.DTO.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User,Long> {
    boolean existsByEmail(String email);
}
