package com.example.mechanic_shop.admin.service;

import com.example.mechanic_shop.admin.DTO.model.requestbody.AddUserRequestBody;
import com.example.mechanic_shop.admin.DTO.model.requestbody.UpdateUserRequestBody;
import com.example.mechanic_shop.admin.DTO.model.responsebody.AddUserResponseBody;
import com.example.mechanic_shop.admin.DTO.model.responsebody.GetUserResponseBody;
import com.example.mechanic_shop.admin.DTO.model.responsebody.UpdateUserResponseBody;

public interface UserService {
    GetUserResponseBody getAllUser();

    AddUserResponseBody addNewUser(AddUserRequestBody requestBody) throws Exception;

    UpdateUserResponseBody updateUser(UpdateUserRequestBody requestBody, Long id);
}
