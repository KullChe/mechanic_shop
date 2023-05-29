package com.example.mechanic_shop.admin.service;

import com.example.mechanic_shop.admin.DTO.model.requestbody.AddUserRequestBody;
import com.example.mechanic_shop.admin.DTO.model.responsebody.AddUserResponseBody;
import com.example.mechanic_shop.admin.DTO.model.responsebody.GetUserResponseBody;

public interface UserService {
    GetUserResponseBody getAllUser();

    AddUserResponseBody addNewUser(AddUserRequestBody requestBody) throws Exception;

}
