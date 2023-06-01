package com.example.mechanic_shop.admin.DTO.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "product")

public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "image")
    private String image;
    @Column(name = "status")
    private String status;
    @Column(name = "price")
    private String price;
    @Column(name = "description")
    private String description;



}
