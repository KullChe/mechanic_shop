package com.example.mechanic_shop.admin.service.impl;

import com.example.mechanic_shop.admin.DTO.entity.Products;
import com.example.mechanic_shop.admin.DTO.model.requestbody.category.AddCategoryRequestBody;
import com.example.mechanic_shop.admin.DTO.model.requestbody.product.AddProductRequestBody;
import com.example.mechanic_shop.admin.DTO.model.responsebody.product.AddProductResponseBody;
import com.example.mechanic_shop.admin.repository.ProductRepo;
import com.example.mechanic_shop.admin.service.ProductService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.sql.Date;

@Service
public class ProductServiceImpl implements ProductService {
    @Value("${path.imageProduct}")
    private String path;
    private final ProductRepo productRepo;


    public ProductServiceImpl(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    @Override
    public String uploadImage(MultipartFile file) throws IOException {
        String fileName = file.getOriginalFilename();
        if (!fileName.toLowerCase().endsWith(".jpg") && !fileName.toLowerCase().endsWith(".png")) {
            throw new IOException("Only JPG and PNG files are allowed");
        }
        String pathToProduct = path + fileName;
        File fileDirectory = new File(pathToProduct);
        if (!fileDirectory.exists()) {
            fileDirectory.mkdirs();
        }
        file.transferTo(new File(pathToProduct));
        return fileName;
    }

    @Override
    public AddProductResponseBody addNewProduct(AddProductRequestBody addProductRequestBody) {
        AddProductResponseBody addProductResponseBody = new AddProductResponseBody();
        if(productRepo.existsByName(addProductRequestBody.getName())){
            addProductResponseBody.setStatus("product is exits");
        }else{
            Products products = new Products();
            products.setName(addProductRequestBody.getName());
            products.setStatus(addProductRequestBody.getStatus());
            products.setPrice(addProductRequestBody.getPrice());
            products.setDescription(addProductRequestBody.getDescription());
            Date presents = new Date(System.currentTimeMillis());
            products.setImage(addProductRequestBody.getImage());
            products.setCreatedDate(presents);
            productRepo.save(products);
            addProductResponseBody.setStatus("Product has been added successfully");
        }
        return addProductResponseBody;
    }
}
