package com.example.mechanic_shop.admin.service;

import com.example.mechanic_shop.admin.DTO.model.requestbody.category.AddCategoryRequestBody;
import com.example.mechanic_shop.admin.DTO.model.requestbody.product.AddProductRequestBody;
import com.example.mechanic_shop.admin.DTO.model.responsebody.product.AddProductResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ProductService {
    String uploadImage(MultipartFile multipartFile) throws IOException;
    AddProductResponseBody addNewProduct(AddProductRequestBody addProductRequestBody);
}
