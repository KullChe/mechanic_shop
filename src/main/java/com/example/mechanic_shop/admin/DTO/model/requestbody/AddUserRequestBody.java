package com.example.mechanic_shop.admin.DTO.model.requestbody;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddUserRequestBody {
    private String name;
    private String imageUrl;
    private String email;
    private String role;
    private String contactNumber;
    private String status;
}
