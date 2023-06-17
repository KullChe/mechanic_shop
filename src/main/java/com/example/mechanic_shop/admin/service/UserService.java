package com.example.mechanic_shop.admin.service;

import com.example.mechanic_shop.admin.DTO.model.requestbody.user.AddUserRequestBody;
import com.example.mechanic_shop.admin.DTO.model.requestbody.user.UpdateUserRequestBody;
import com.example.mechanic_shop.admin.DTO.model.responsebody.user.AddUserResponseBody;
import com.example.mechanic_shop.admin.DTO.model.responsebody.user.DeleteUserResponseBody;
import com.example.mechanic_shop.admin.DTO.model.responsebody.user.GetUserResponseBody;
import com.example.mechanic_shop.admin.DTO.model.responsebody.user.UpdateUserResponseBody;

public interface UserService {
    GetUserResponseBody getAllUser();

//    AddUserResponseBody addNewUser(AddUserRequestBody requestBody) throws Exception;

    UpdateUserResponseBody updateUser(UpdateUserRequestBody requestBody, Long id);
    DeleteUserResponseBody deleteUserById (Long id);

}
