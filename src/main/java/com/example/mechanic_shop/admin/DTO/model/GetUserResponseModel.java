package com.example.mechanic_shop.admin.DTO.model;

import lombok.Data;

import java.sql.Date;


@Data
public class GetUserResponseModel {
    private Long id;
    private String name;
    private String imageUrl;
    private String role;
    private String contactNumber;
    private String status;
    private Date createdDate;
    private Date updatedDate;
    private String email;
}
