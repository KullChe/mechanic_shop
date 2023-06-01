package com.example.mechanic_shop.admin.repository;

import com.example.mechanic_shop.admin.DTO.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepo extends JpaRepository<Category,Long> {
    boolean existsByName(String name);
}
