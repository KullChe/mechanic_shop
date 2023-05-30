package com.example.mechanic_shop.admin.DTO.model.requestbody;

import lombok.Data;

import java.sql.Date;

@Data
public class UpdateUserRequestBody {
    private String name;
    private String imageUrl;
    private String email;
    private String role;
    private String contactNumber;
    private String status;
    private Date updatedDate;
}
