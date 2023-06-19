package com.example.mechanic_shop.admin.DTO.model.requestbody.product;

import lombok.Data;

@Data
public class AddProductRequestBody {
    private String name;
    private String price;
    private String status;
    private String description;
    private String image;
    private String categoryId;
}
