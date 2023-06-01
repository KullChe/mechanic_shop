package com.example.mechanic_shop.admin.DTO.model.requestbody.category;

import lombok.Data;

import java.sql.Date;
@Data
public class UpdateCategoryRequestBody  {
    private String name;
    private String status;
    private Date updatedDate;
}
