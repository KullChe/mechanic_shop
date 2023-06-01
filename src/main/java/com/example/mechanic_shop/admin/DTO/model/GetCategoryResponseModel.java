package com.example.mechanic_shop.admin.DTO.model;

import lombok.Data;

import java.sql.Date;

@Data
public class GetCategoryResponseModel {
    private Long id;
    private String name;
    private Date createdDate;
    private Date updatedDate;
    private String status;
}
