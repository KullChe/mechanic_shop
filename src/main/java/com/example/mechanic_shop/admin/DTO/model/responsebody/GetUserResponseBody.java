package com.example.mechanic_shop.admin.DTO.model.responsebody;

import com.example.mechanic_shop.admin.DTO.model.GetUserResponseModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetUserResponseBody {
    private List<GetUserResponseModel> userModelList;
}
