package com.example.mechanic_shop.admin.service.impl;

import com.example.mechanic_shop.admin.DTO.entity.Category;
import com.example.mechanic_shop.admin.DTO.model.GetCategoryResponseModel;
import com.example.mechanic_shop.admin.DTO.model.requestbody.category.AddCategoryRequestBody;
import com.example.mechanic_shop.admin.DTO.model.requestbody.category.UpdateCategoryRequestBody;
import com.example.mechanic_shop.admin.DTO.model.responsebody.category.AddCategoryResponseBody;
import com.example.mechanic_shop.admin.DTO.model.responsebody.category.GetCategoryResponseBody;
import com.example.mechanic_shop.admin.DTO.model.responsebody.category.UpdateCategoryResponseBody;
import com.example.mechanic_shop.admin.repository.CategoryRepo;
import com.example.mechanic_shop.admin.service.CategoryService;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CateServiceImpl implements CategoryService {

    private final CategoryRepo categoryRepo;

    public CateServiceImpl(CategoryRepo categoryRepo) {
        this.categoryRepo = categoryRepo;
    }


    @Override
    public GetCategoryResponseBody getAllCategory() {
        List<Category> categoryList = categoryRepo.findAll();
        GetCategoryResponseBody responseBody = new GetCategoryResponseBody();
        List<GetCategoryResponseModel> cateModelList = categoryList.stream().map(c->{
            GetCategoryResponseModel cateModel = new GetCategoryResponseModel();
            cateModel.setId(c.getId());
            cateModel.setName(c.getName());
            cateModel.setCreatedDate(c.getCreatedDate());
            cateModel.setUpdatedDate(c.getUpdatedDate());
            cateModel.setStatus(c.getStatus());
            return cateModel;
        }).collect(Collectors.toList());
        responseBody.setCateModelList(cateModelList);
        return responseBody;
    }

    @Override
    public UpdateCategoryResponseBody updateCategory(Long id, UpdateCategoryRequestBody updateCategoryRequestBody) {
        UpdateCategoryResponseBody responseBody = new UpdateCategoryResponseBody();
        Category category = categoryRepo.findById(id).orElse(null);
        if(category==null){
            responseBody.setStatus("not found category");
        } else if (categoryRepo.existsByName(updateCategoryRequestBody.getName()) && !category.getName().equals(updateCategoryRequestBody.getName())) {
            responseBody.setStatus("name is exits");
        } else {
            category.setName(updateCategoryRequestBody.getName());
            Date present = new Date(System.currentTimeMillis());
            category.setStatus(updateCategoryRequestBody.getStatus());
            category.setUpdatedDate(present);
            categoryRepo.save(category);
            responseBody.setStatus("success");
        }
        return responseBody;
    }

    @Override
    public AddCategoryResponseBody addCategory(AddCategoryRequestBody addCategoryRequestBody) {
        AddCategoryResponseBody addCategoryResponseBody = new AddCategoryResponseBody();
        if(categoryRepo.existsByName(addCategoryRequestBody.getName())){
            addCategoryResponseBody.setStatus("name is exits");
        }else{
            Category category = new Category();
            category.setName(addCategoryRequestBody.getName());
            category.setStatus(addCategoryRequestBody.getStatus());
            Date present = new Date(System.currentTimeMillis());
            category.setCreatedDate(present);
            categoryRepo.save(category);
            addCategoryResponseBody.setStatus("success");
        }
        return addCategoryResponseBody;
    }
}
