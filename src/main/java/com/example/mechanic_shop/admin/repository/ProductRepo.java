package com.example.mechanic_shop.admin.repository;

import com.example.mechanic_shop.admin.DTO.entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends JpaRepository<Products, Long> {
}
