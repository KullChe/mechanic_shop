package com.example.mechanic_shop.admin.api;

import com.example.mechanic_shop.admin.DTO.model.requestbody.category.AddCategoryRequestBody;
import com.example.mechanic_shop.admin.DTO.model.requestbody.category.UpdateCategoryRequestBody;
import com.example.mechanic_shop.admin.DTO.model.responsebody.category.AddCategoryResponseBody;
import com.example.mechanic_shop.admin.DTO.model.responsebody.category.GetCategoryResponseBody;
import com.example.mechanic_shop.admin.DTO.model.responsebody.category.UpdateCategoryResponseBody;
import com.example.mechanic_shop.admin.service.CategoryService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/api/category")
public class CategoryRestApi {
    private final CategoryService categoryService;

    public CategoryRestApi(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/list")
    public GetCategoryResponseBody getAllCate(){
        return categoryService.getAllCategory();
    }
    @PutMapping("/edit")
    public UpdateCategoryResponseBody updateCategoryResponseBody(@RequestBody UpdateCategoryRequestBody updateCategoryRequestBody,
                                                                 @RequestParam(value = "id") Long id){
        return categoryService.updateCategory(id,updateCategoryRequestBody);
    }
    @PostMapping("/add")
    public AddCategoryResponseBody addNewCategory(@RequestBody AddCategoryRequestBody addCategoryRequestBody){
        return categoryService.addCategory(addCategoryRequestBody);
    }
}
