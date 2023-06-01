package com.example.mechanic_shop.admin.DTO.model.responsebody.category;

import com.example.mechanic_shop.admin.DTO.model.GetCategoryResponseModel;
import lombok.Data;

import java.util.List;
@Data
public class GetCategoryResponseBody {
    private List<GetCategoryResponseModel> cateModelList;
}
