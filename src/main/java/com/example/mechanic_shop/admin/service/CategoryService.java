package com.example.mechanic_shop.admin.service;

import com.example.mechanic_shop.admin.DTO.model.requestbody.category.AddCategoryRequestBody;
import com.example.mechanic_shop.admin.DTO.model.requestbody.category.UpdateCategoryRequestBody;
import com.example.mechanic_shop.admin.DTO.model.responsebody.category.AddCategoryResponseBody;
import com.example.mechanic_shop.admin.DTO.model.responsebody.category.GetCategoryResponseBody;
import com.example.mechanic_shop.admin.DTO.model.responsebody.category.UpdateCategoryResponseBody;

public interface CategoryService {
    GetCategoryResponseBody getAllCategory();
    UpdateCategoryResponseBody updateCategory(Long id, UpdateCategoryRequestBody updateCategoryRequestBody);
    AddCategoryResponseBody addCategory(AddCategoryRequestBody addCategoryRequestBody);

}
