package com.example.mechanic_shop.admin.api;

import com.example.mechanic_shop.admin.DTO.model.requestbody.product.AddProductRequestBody;
import com.example.mechanic_shop.admin.DTO.model.responsebody.product.AddProductResponseBody;
import com.example.mechanic_shop.admin.service.ProductService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/admin/api/product")
public class ProductRestApi {
    private final ProductService productService;

    public ProductRestApi(ProductService productService) {
        this.productService = productService;
    }
    @PostMapping("/upload")
    public String uploadImage(@RequestParam MultipartFile file) throws IOException {
        return productService.uploadImage(file);
    }
    @PostMapping("/add")
    public AddProductResponseBody addNewProduct(@RequestBody AddProductRequestBody addProductRequestBody){
        return productService.addNewProduct(addProductRequestBody);
    }
}
